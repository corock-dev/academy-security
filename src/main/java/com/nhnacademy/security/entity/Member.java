package com.nhnacademy.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;

    @Column
    private String name;

    @Column(name = "pwd")
    private String pwd;

    @OneToOne
    Authorities authorities;

}
