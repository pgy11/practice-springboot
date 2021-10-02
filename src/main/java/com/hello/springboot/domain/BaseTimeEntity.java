package com.hello.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA 엔티티 클래스들이 이 추상 클래스를 상속할 경우, 추상 클래스 내 멤버면수들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate // 엔티티가 생성되어 저장될 때, 생성 시간을 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 엔티티의 내용이 변결될 때, 변경된 시간을 자동 저장
    private LocalDateTime modifiedDate;


}
