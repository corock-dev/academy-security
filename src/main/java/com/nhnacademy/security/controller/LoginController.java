package com.nhnacademy.security.controller;

import com.nhnacademy.security.entity.LoginRequest;
import com.nhnacademy.security.entity.Member;
import com.nhnacademy.security.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String doLogin(@ModelAttribute LoginRequest loginRequest, BindingResult bindingResult,
                          HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        Member loggedMember = loginService.login(loginRequest.getUsername(), loginRequest.getPassword());

        if (loggedMember == null) {
            bindingResult.rejectValue("loginFailed", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "form";
        }

        HttpSession session = request.getSession(true);

        session.setAttribute("sessionUsername", loggedMember.getUsername());

        return "redirect:/login-success";
    }

}
