package com.microservice.Comment.PayLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String postid;
    private String title;
    private String desciption;
    private String contebnt;
}

