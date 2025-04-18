package com.vti.blog_app01.form;

import com.vti.blog_app01.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentFilterForm {
    private String search;
    private Long postId;
    private Comment.Status status;
}
