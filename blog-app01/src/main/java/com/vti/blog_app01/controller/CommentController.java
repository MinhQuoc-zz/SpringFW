package com.vti.blog_app01.controller;

import com.vti.blog_app01.dto.CommentDto;
import com.vti.blog_app01.form.CommentCreateForm;
import com.vti.blog_app01.form.CommentFilterForm;
import com.vti.blog_app01.form.CommentUpdateForm;
import com.vti.blog_app01.mapper.CommentMapper;
import com.vti.blog_app01.service.CommentSercice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class CommentController {
    @Autowired
    private CommentSercice commentSercice;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(CommentFilterForm form,Pageable pageable){
        return commentSercice.findAll(form,pageable);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<CommentDto> findByPostId(@PathVariable("postId") Long postId,Pageable pageable){
         return commentSercice.findByPostId(postId,pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    private CommentDto finfById(@PathVariable("id") String id){
        return commentSercice.findById(id);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(@Valid  @RequestBody CommentUpdateForm form, @PathVariable("id") String id){
        return commentSercice.update(form,id);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteById(@PathVariable("id") String id){
        commentSercice.deleteById(id);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(@Valid @RequestBody CommentCreateForm form,@PathVariable("postId") Long postId){
        return commentSercice.create(form,postId);
    }
}
