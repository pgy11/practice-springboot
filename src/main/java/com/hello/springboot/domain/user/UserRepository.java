package com.hello.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 이미 가입했는지 또는 처음 가입했는지를 알기 위한 메소드
    Optional<User> findByEmail(String email);
}
