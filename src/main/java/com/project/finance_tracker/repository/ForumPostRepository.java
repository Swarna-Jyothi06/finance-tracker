package com.project.finance_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.finance_tracker.entity.ForumPost;

public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {
}