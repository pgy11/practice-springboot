package com.hello.springboot.web.dto;

import com.hello.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

/*
* Entity 클래스와 유사함에도 별도의 클래스를 만든이유는 DB레이어와 View레이어를 분리하기 위함.
* View레이어는 자주 변경된다. 이를 위한 별도의 dto를 만들어서 처리하자.
* */