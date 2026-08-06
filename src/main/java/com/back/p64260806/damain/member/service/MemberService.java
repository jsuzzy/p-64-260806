package com.back.p64260806.damain.member.service;

import com.back.p64260806.damain.member.entity.Member;
import com.back.p64260806.damain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(String username, String nickname) {
        return memberRepository.save(new Member(username, nickname));
    }

    public long count() {
        return memberRepository.count();
    }
}
