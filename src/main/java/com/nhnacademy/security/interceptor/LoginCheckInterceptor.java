package com.nhnacademy.security.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.util.Objects.isNull;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession();

        if (isNull(session) || isNull(session.getAttribute("loggedMember"))) {
            log.info("인증되지 않은 사용자의 요청이 들어왔습니다.");
            response.sendRedirect("/login");

            return false;
        }

        return true;
    }

}
