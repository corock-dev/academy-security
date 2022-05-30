package com.nhnacademy.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginRequest {
    private String username;
    private String password;
}
