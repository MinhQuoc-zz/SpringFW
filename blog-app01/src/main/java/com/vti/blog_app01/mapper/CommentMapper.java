package com.vti.blog_app01.mapper;

import com.vti.blog_app01.dto.CommentDto;
import com.vti.blog_app01.entity.Comment;
import com.vti.blog_app01.form.CommentCreateForm;
import com.vti.blog_app01.form.CommentUpdateForm;

public class CommentMapper {
    public static Comment map(CommentCreateForm form){
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        comment.setStatus(form.getStatus());
        return comment;
    }

    public static CommentDto map(Comment comment){
        var dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        dto.setStatus(comment.getStatus());
        dto.setCraetedAt(comment.getCraetedAt());
        dto.setUpdateAt(comment.getUpdateAt());
        return dto;
    }

    public static void map(CommentUpdateForm form, Comment comment) {
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        comment.setStatus(form.getStatus());
    }
}
