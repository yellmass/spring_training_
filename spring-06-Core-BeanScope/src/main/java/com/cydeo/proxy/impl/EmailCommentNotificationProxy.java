package com.cydeo.proxy.impl;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for the comment: " + comment.getText());
    }
}
