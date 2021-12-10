package io.starter.jpatutorial.domain.repository;

import io.starter.jpatutorial.domain.jpo.PostJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMariaRepository extends JpaRepository<PostJpo, Long> {
    @Query("SELECT P FROM PostJpo P LEFT OUTER JOIN FETCH P.comments")
    List<PostJpo> findAllFetchJoin();
    List<PostJpo> findByTitleContains(String keyword);
}
