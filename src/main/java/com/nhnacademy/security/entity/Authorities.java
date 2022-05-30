package com.nhnacademy.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Authorities {

    @Id
    @JoinColumn(name = "member_id")
    private String memberId;

    @Column
    private String authority;

}
