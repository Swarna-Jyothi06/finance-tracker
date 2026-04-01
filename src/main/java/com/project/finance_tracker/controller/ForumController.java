package com.project.finance_tracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.finance_tracker.entity.ForumComment;
import com.project.finance_tracker.entity.ForumLike;
import com.project.finance_tracker.entity.ForumPost;
import com.project.finance_tracker.service.ForumService;

@RestController
@RequestMapping("/forum")
@CrossOrigin
public class ForumController {

    @Autowired
    private ForumService forumService;

    @PostMapping("/post")
    public ForumPost createPost(@RequestBody ForumPost post) {
        return forumService.createPost(post);
    }

    @GetMapping("/posts")
    public List<ForumPost> getAllPosts() {
        return forumService.getAllPosts();
    }

    @PostMapping("/comment")
    public ForumComment addComment(@RequestBody ForumComment comment) {
        return forumService.addComment(comment);
    }

    @GetMapping("/comments/{postId}")
    public List<ForumComment> getComments(@PathVariable Long postId) {
        return forumService.getCommentsByPostId(postId);
    }

    @PostMapping("/like")
    public ForumLike addLike(@RequestBody ForumLike like) {
        return forumService.addLike(like);
    }

    @GetMapping("/details/{postId}")
    public Map<String, Object> getPostDetails(@PathVariable Long postId) {
        return forumService.getPostDetails(postId);
    }
}