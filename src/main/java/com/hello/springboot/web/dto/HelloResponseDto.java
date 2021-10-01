package com.hello.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 멤버변수에 대해, get메소드 생성
@RequiredArgsConstructor // 생성자를 통해 final 멤버변수 초기화
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
