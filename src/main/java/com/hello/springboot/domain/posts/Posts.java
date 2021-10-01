package com.hello.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity // 테이블과 매핑되는 개체, 테이블 명은 클래스명의 언더스코어 명
public class Posts {
    
    @Id// 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 적용
    private long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author; // 기본값을 사용할 경우, @Column 안써도된다.

    @Builder // 해당클래스의 빌더패턴 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    
    
}
