package com.hello.springboot.web.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;
import com.hello.springboot.domain.posts.Posts;
import com.hello.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정을 하지 않으면, H2데이터베이스를 자동실행
public class PostRepositoryTest {

    @Autowired
    PostsRepository postRepository;

    @After // Junit에서 단위테스트가 끝날때마다 수행되는 메소드
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // save()는 sql의 insert/update
        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hello@example.com")
                .build());

        List<Posts> postsList = postRepository.findAll(); // sql의 select * from posts

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){

        // given
        LocalDateTime now = LocalDateTime.of(2021,10,2,0,0,0);
        postRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // when
        List<Posts> postsList = postRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        System.out.println(
                ">>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate()
        );
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
