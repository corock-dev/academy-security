package com.nhnacademy.security.repository;

import com.nhnacademy.security.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
