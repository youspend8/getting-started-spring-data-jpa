package io.starter.jpatutorial.domain.model;

import io.starter.jpatutorial.domain.jpo.PostJpo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    private Long no;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private int views;
    private List<Comment> comments;

    /**
     * Jpo -> Domain 객체 변환
     */
    public static Post jpoOf(PostJpo postJpo) {
        Post post = new Post();
        BeanUtils.copyProperties(postJpo, post);
        post.comments = postJpo.getComments().stream()
                .map(Comment::jpoOf)
                .collect(Collectors.toList());
        return post;
    }

    /**
     * Domain 객체 -> Jpo 변환
     */
    public PostJpo asJpo() {
        PostJpo postJpo = new PostJpo();
        BeanUtils.copyProperties(this, postJpo);
        postJpo.setComments(comments.stream()
                .map(Comment::asJpo)
                .collect(Collectors.toList()));
        return postJpo;
    }
}
