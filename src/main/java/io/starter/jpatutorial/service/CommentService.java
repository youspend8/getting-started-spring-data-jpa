package io.starter.jpatutorial.service;

import io.starter.jpatutorial.domain.jpo.PostJpo;
import io.starter.jpatutorial.domain.model.Comment;
import io.starter.jpatutorial.domain.repository.PostMariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostMariaRepository postMariaRepository;

    @Transactional
    public void save(long postNo, Comment comment) {
        PostJpo postJpo = postMariaRepository.findById(postNo)
                .orElseThrow(IllegalArgumentException::new);
        postJpo.addComment(comment.asJpo());
    }
}
