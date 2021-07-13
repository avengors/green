package com.avengors.service;

import com.avengors.entity.Member;
import com.avengors.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member join(Member member) {
        if (isUserIdDuplicated(member.getUserId())) {
            throw new IllegalStateException();
        }

        memberRepository.save(member);
        return memberRepository.findByUserId(member.getUserId()).get();
    }

    private boolean isUserIdDuplicated(String userId) {
        return memberRepository.findByUserId(userId).isPresent();
    }

    public Member login(String userId, String userPw) {
        return memberRepository.findByUserIdAndUserPw(userId, userPw).orElseThrow(() -> new IllegalStateException("Invalid account"));
    }
}
