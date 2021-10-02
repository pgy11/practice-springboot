package com.hello.springboot.domain.posts;

import com.hello.springboot.domain.BaseTimeEntity;
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
public class Posts extends BaseTimeEntity {
    
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

    /*
    * DB에 update 쿼리를 날리지 않아도 수행되는 이유는 JPA 영속성 컨텍스트때문이다.
    * 영속성 컨텍스트는 엔티티를 영구적으로 저장하는 환경
    * 트랜잭션 속에서 DB로부터 데이터를 가져오면 해당 데이터는 영속성 컨텍스트가 유지됨(단, JPA엔티티 매니저가 활성화 상태)
    * 트랜잭션이 끝나는 시점에 테이블에 변경된 데이터가 반영
    * 위의 개념을 더티 체킹이라고 한다.
    * */
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}