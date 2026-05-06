package com.ch.libraryflow.member.service;

import com.ch.libraryflow.common.exception.MemberNotFoundException;
import com.ch.libraryflow.member.domain.Member;
import com.ch.libraryflow.member.dto.MemberRegisterRequest;
import com.ch.libraryflow.member.dto.MemberRegisterResponse;
import com.ch.libraryflow.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberRegisterResponse registerMember(MemberRegisterRequest request){
        Member member = Member.create(request.username(),request.email());
        Member savedMember = memberRepository.save(member);

        return new MemberRegisterResponse(savedMember.getUsername(),savedMember.getEmail());
    }

    public MemberRegisterResponse findByMemberId(Long memberId){
        Member findMember = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);

        return new MemberRegisterResponse(findMember.getUsername(),findMember.getEmail());
    }
}

/*
* TODO:
*  	•	대출 정책 엔진: OCP 연습 최고
* 	•	예약 대출 기능: 상태 전이, 도메인 설계 연습 최고
* 	•	연체료 계산: 계산 로직, 전략 분리 연습 좋음
* */