package com.nhnacademy.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @Column(name = "member_id")
    private String username;

    @Column
    private String name;

    @Column(name = "pwd")
    private String password;

    @OneToOne
    Authorities authorities;

}
