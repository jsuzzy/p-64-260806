package com.back.p64260806.damain.member.repository;

import com.back.p64260806.damain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
