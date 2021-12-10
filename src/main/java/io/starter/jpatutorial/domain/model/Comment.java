package io.starter.jpatutorial.domain.model;

import io.starter.jpatutorial.domain.jpo.CommentJpo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    private Long id;
    private Long postNo;
    private String content;
    private LocalDateTime createdAt;

    public static Comment jpoOf(CommentJpo commentJpo) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentJpo, comment);
        return comment;
    }

    public CommentJpo asJpo() {
        CommentJpo commentJpo = new CommentJpo();
        BeanUtils.copyProperties(this, commentJpo);
        return commentJpo;
    }
}
