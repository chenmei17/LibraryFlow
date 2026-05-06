package com.ch.libraryflow.member.controller;

import com.ch.libraryflow.member.dto.MemberRegisterRequest;
import com.ch.libraryflow.member.dto.MemberRegisterResponse;
import com.ch.libraryflow.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberRegisterResponse> registerMember(@RequestBody MemberRegisterRequest request){
        MemberRegisterResponse response = memberService.registerMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberRegisterResponse> findMember(@PathVariable Long memberId){
        MemberRegisterResponse response = memberService.findByMemberId(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
