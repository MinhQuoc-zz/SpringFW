package com.vti.blog_app01.form;

import com.vti.blog_app01.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateForm {
    private String name;
    private String email;
    private String body;
    private Comment.Status status;
}
