package com.vti.blog_app01.mapper;

import com.vti.blog_app01.dto.PostDto;
import com.vti.blog_app01.entity.Post;
import com.vti.blog_app01.form.PostCreateForm;
import com.vti.blog_app01.form.PostUpdateForm;

public class PostMapper {
    //map từ form sang entity
    public static Post map(PostCreateForm form){
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setDescription(form.getDescription());
        post.setContent(form.getContent());
        return post;
    }

    //map từ entity sang dto
    public static PostDto map(Post post){
        var dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());

        return dto.withSelfRel();
    }

    public static void map(PostUpdateForm form, Post post) {
        post.setTitle(form.getTitle());
        post.setDescription(form.getDescription());
        post.setContent(form.getContent());
    }
}
