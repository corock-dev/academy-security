package com.nhnacademy.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// TODO #1: web.xml을 없애고 AbstractSecurityWebApplicationInitializer 를 상속받아도
//          `springSecurityFilterChain` 필터를 구성할 수 있다
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
