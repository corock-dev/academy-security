package com.nhnacademy.security.service;

import com.nhnacademy.security.entity.Member;
import com.nhnacademy.security.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Member login(String username, String password) {
        return loginRepository.findMemberByUsernameAndPassword(username, password);
    }

}
