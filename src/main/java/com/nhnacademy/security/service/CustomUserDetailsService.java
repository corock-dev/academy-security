package com.nhnacademy.security.service;

import com.nhnacademy.security.domain.Member;
import com.nhnacademy.security.repository.AuthorityRepository;
import com.nhnacademy.security.repository.MemberRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

// TODO #3: UserDetailsService 구현
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final AuthorityRepository authorityRepository;

    public CustomUserDetailsService(MemberRepository memberRepository, AuthorityRepository authorityRepository) {
        this.memberRepository = memberRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberOptional = memberRepository.findById(username);
        if (memberOptional.isEmpty()) {
            return null;
        }

        Authority authority = authorityRepository.findById(username);

        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());

        return new User(member.getId(), member.getPassword(), Collections.singletonList(grantedAuthority));
    }

}
