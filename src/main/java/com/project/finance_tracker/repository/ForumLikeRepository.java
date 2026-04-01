package com.project.finance_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.finance_tracker.entity.ForumLike;

public interface ForumLikeRepository extends JpaRepository<ForumLike, Long> {
    List<ForumLike> findByPostId(Long postId);
}
