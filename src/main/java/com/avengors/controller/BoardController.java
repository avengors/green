package com.avengors.controller;

import com.avengors.entity.Member;
import com.avengors.entity.Post;
import com.avengors.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/board")
public class BoardController {

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private PostService postService;

    @GetMapping("/board")
    public void board() {
    }

    @GetMapping("/introduce")
    public void introduce() {
    }

    @GetMapping("/news")
    public void news() {
    }

    @GetMapping("oneword")
    public void oneword() {
    }

    @GetMapping("write")
    public void writeForm() {
    }

    @PostMapping("/write")
    public String write(
            @RequestParam(name = "uploadFile") MultipartFile file,
            @ModelAttribute Post post,
            @SessionAttribute Member member,
            HttpServletRequest request
    ) throws IOException {
        Post uploadPost = postService.write(member.getIdx(), post, file, request.getSession().getServletContext().getRealPath("upload"));

        log.info("uploadPost = {}", uploadPost);

        return "redirect:/";
    }
}
