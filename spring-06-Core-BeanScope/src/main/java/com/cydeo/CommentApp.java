package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("John Doe");
        comment.setText("lorem ipsum lorem ipsum");

        ApplicationContext container = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService cs1 = container.getBean(CommentService.class);
        CommentService cs2 = container.getBean(CommentService.class);

        System.out.println(cs1==cs2);  //true if scope of CommentService bean is 'singleton', false if it is 'prototype'
    }
}
