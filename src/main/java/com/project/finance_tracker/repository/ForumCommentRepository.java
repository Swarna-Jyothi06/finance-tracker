package com.project.finance_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.finance_tracker.entity.ForumComment;

public interface ForumCommentRepository extends JpaRepository<ForumComment, Long> {
    List<ForumComment> findByPostId(Long postId);
}
