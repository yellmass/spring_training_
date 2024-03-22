package com.cydeo.repository.impl;

import com.cydeo.model.Comment;
import com.cydeo.repository.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
