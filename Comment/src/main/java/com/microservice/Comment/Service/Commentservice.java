package com.microservice.Comment.Service;

import com.microservice.Comment.Configuration.RestTemplateConfig;
import com.microservice.Comment.Entity.Comment;
import com.microservice.Comment.PayLoad.Post;
import com.microservice.Comment.Repositary.Commentrepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Commentservice {
    @Autowired
    private Commentrepositary Commentrepo;
    @Autowired
    private RestTemplateConfig restTemplate;
    public Comment saveComment(Comment comment){
     Post post=restTemplate.getRestTemplate().getForObject("http://POST_SERVICE/api/posts/"+comment.getPostId(), Post.class);
     if(post!=null){
         String commentId= UUID.randomUUID().toString();
         comment.setCommentId(commentId);
         Comment saveComment = Commentrepo.save(comment);
         return saveComment;
     }else {
         return null;
     }
    }
    public List<Comment > getAllCommentsByPostId(String postId){
        List<Comment> allCommentsByPostId = Commentrepo.getAllCommentsByPostId(postId);
        return allCommentsByPostId;
    }
}
