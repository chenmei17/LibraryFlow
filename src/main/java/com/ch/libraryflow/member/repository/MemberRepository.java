package com.ch.libraryflow.member.repository;

import com.ch.libraryflow.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
