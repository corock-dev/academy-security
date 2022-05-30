package com.nhnacademy.security.controller;

import com.nhnacademy.security.entity.LoginRequest;
import com.nhnacademy.security.entity.Member;
import com.nhnacademy.security.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static java.util.Objects.isNull;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login() {
        return "form";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute LoginRequest loginRequest, HttpSession session) {

        Member loggedMember = loginService.login(loginRequest.getId(), loginRequest.getPwd());
        if (isNull(loggedMember) || isNull(session.getAttribute("sessionId"))) {
            return "redirect:/form";
        }
        session.setAttribute("sessionId", loggedMember.getId());

        return "redirect:/login-success";
    }

}
