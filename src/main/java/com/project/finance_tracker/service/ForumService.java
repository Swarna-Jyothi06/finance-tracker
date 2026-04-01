package com.project.finance_tracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.finance_tracker.entity.ForumComment;
import com.project.finance_tracker.entity.ForumLike;
import com.project.finance_tracker.entity.ForumPost;
import com.project.finance_tracker.repository.ForumCommentRepository;
import com.project.finance_tracker.repository.ForumLikeRepository;
import com.project.finance_tracker.repository.ForumPostRepository;

@Service
public class ForumService {

    @Autowired
    private ForumPostRepository forumPostRepository;

    @Autowired
    private ForumCommentRepository forumCommentRepository;

    @Autowired
    private ForumLikeRepository forumLikeRepository;

    public ForumPost createPost(ForumPost post) {
        return forumPostRepository.save(post);
    }

    public List<ForumPost> getAllPosts() {
        return forumPostRepository.findAll();
    }

    public ForumComment addComment(ForumComment comment) {
        return forumCommentRepository.save(comment);
    }

    public List<ForumComment> getCommentsByPostId(Long postId) {
        return forumCommentRepository.findByPostId(postId);
    }

    public ForumLike addLike(ForumLike like) {
        return forumLikeRepository.save(like);
    }

    public int getLikeCount(Long postId) {
        return forumLikeRepository.findByPostId(postId).size();
    }

    public Map<String, Object> getPostDetails(Long postId) {
        Map<String, Object> result = new HashMap<>();
        ForumPost post = forumPostRepository.findById(postId).orElse(null);
        List<ForumComment> comments = forumCommentRepository.findByPostId(postId);
        int likes = forumLikeRepository.findByPostId(postId).size();

        result.put("post", post);
        result.put("comments", comments);
        result.put("likes", likes);

        return result;
    }
}