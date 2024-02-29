package com.microservice.Comment.Controller;

import com.microservice.Comment.Entity.Comment;
import com.microservice.Comment.Service.Commentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    //http://localhost:8082/api/comments
    @Autowired
    private Commentservice commentservice;
    @PostMapping
    public ResponseEntity<?> saveComment(@RequestBody Comment comment){
        Comment c = commentservice.saveComment(comment);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    @GetMapping("{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable String postId){
     List<Comment>comments=commentservice.getAllCommentsByPostId(postId);
     return comments;
    }

}
