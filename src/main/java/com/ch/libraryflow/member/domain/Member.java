package com.ch.libraryflow.member.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    protected Member() {}

    private Member(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public static Member create(String username, String email) {
        return new Member(username, email);
    }

}
