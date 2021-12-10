package io.starter.jpatutorial;

import io.starter.jpatutorial.domain.model.Comment;
import io.starter.jpatutorial.domain.model.Post;
import io.starter.jpatutorial.service.CommentService;
import io.starter.jpatutorial.service.PostListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {
    @Autowired
    private PostListService postListService;

    @Autowired
    private CommentService commentService;

    @ParameterizedTest
    @ValueSource(strings = "1")
    @DisplayName("게시글의 제목이 특정 키워드를 포함 목록 조회 테스트")
    void fetch(String keyword) {
        List<Post> posts = postListService.fetchByContains(keyword);
        Assertions.assertNotEquals(posts.size(), 0);
        System.out.println("Posts --> " + posts);
    }

    @Test
    @DisplayName("게시글 목록 전체 조회 (Fetch Join) 테스트")
    void fetch() {
        List<Post> posts = postListService.fetch();
        Assertions.assertNotNull(posts);
        System.out.println("Posts --> " + posts);
    }

    @Test
    @DisplayName("게시글 생성 테스트")
    void save() {
        List<Post> posts = Arrays.asList(
                Post.builder().title("게시글 1").content("게시글 1 내용").build(),
                Post.builder().title("게시글 2").content("게시글 2 내용").build(),
                Post.builder().title("게시글 3").content("게시글 3 내용").build()
        );
        postListService.save(posts);
    }

    @Test
    @DisplayName("게시글 댓글 생성 테스트")
    void saveComment() {
        Comment comment = Comment.builder()
                .content("게시글 1의 첫번째 댓글")
                .build();
        commentService.save(1, comment);
    }
}
