package com.vti.blog_app01.dto;

import com.vti.blog_app01.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CommentDto {
    private String id;
    private String name;
    private String email;
    private String body;
    private Comment.Status status;
    private LocalDateTime craetedAt;
    private LocalDateTime updateAt;
}
