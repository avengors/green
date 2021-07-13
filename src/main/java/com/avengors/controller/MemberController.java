package com.avengors.controller;

import com.avengors.entity.Member;
import com.avengors.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final Logger log = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @GetMapping("/join")
    public void joinForm() {
    }

    @PostMapping("/join")
    public String join(
            @ModelAttribute Member member,
            HttpSession session
    ) {
        memberService.join(member);

        session.setAttribute("member", member);
        log.info("member = {}", member);

        return "redirect:/";
    }

    @GetMapping("/login")
    public void loginForm() {
    }

    @PostMapping("/login")
    public String login(String userId, String userPw, HttpSession session) {
        Member member = memberService.login(userId, userPw);
        session.setAttribute("member", member);
        log.info("findByUserIdAndUserPw success, member = {}", member);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("member");
        return "redirect:/";
    }
}
