package io.starter.jpatutorial.service;

import io.starter.jpatutorial.domain.jpo.PostJpo;
import io.starter.jpatutorial.domain.model.Post;
import io.starter.jpatutorial.domain.repository.PostMariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostListService {
    private final PostMariaRepository postMariaRepository;

    @Transactional(readOnly = true)
    public List<Post> fetchByContains(String title) {
        return postMariaRepository.findByTitleContains(title)
                .stream()
                .map(Post::jpoOf)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Post> fetch() {
        return postMariaRepository.findAllFetchJoin()
                .stream()
                .map(Post::jpoOf)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(List<Post> posts) {
        List<PostJpo> postJpos = posts.stream()
                .map(Post::asJpo)
                .collect(Collectors.toList());

        postMariaRepository.saveAll(postJpos);
    }
}
