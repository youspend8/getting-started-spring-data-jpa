package io.starter.jpatutorial.domain.jpo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class CommentJpo {
    /**
     * 댓글 고유 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    /**
     * 게시글 번호
     */
    private Long postNo;

    /**
     * 댓글 내용
     */
    private String content;

    /**
     * 댓글 작성 일시
     */
    private LocalDateTime createdAt;
}
