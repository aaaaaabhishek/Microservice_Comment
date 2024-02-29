package com.microservice.Comment.Repositary;

import com.microservice.Comment.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Commentrepositary extends JpaRepository<Comment,String> {
    List<Comment> getAllCommentsByPostId(String postId);
    List<Comment> findByPostId(String postId);
}
