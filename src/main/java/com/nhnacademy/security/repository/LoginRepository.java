package com.nhnacademy.security.repository;

import com.nhnacademy.security.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Member, String> {
}
