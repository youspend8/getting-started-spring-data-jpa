package io.starter.jpatutorial.domain.jpo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class PostJpo {
    /**
     * 게시글 번호 (Auto Increment)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no = 0L;

    /**
     * 게시글 제목
     */
    private String title;

    /**
     * 게시글 내용
     */
    private String content;

    /**
     * 게시글 작성 일시
     */
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 조회수
     */
    private int views = 0;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postNo")
    private List<CommentJpo> comments = new ArrayList<>();

    /**
     * 댓글 생성
     */
    public void addComment(CommentJpo commentJpo) {
        this.comments.add(commentJpo);
    }
}
