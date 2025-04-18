package com.vti.blog_app01.service;

import com.vti.blog_app01.dto.CommentDto;
import com.vti.blog_app01.form.CommentCreateForm;
import com.vti.blog_app01.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentSercice {

    Page<CommentDto> findAll(Pageable pageable);

    Page<CommentDto> findByPostId(Long postId,Pageable pageable);

    CommentDto findById(String id);

    CommentDto create(CommentCreateForm form,Long postId);

    CommentDto update(CommentUpdateForm form, String id);

    void deleteById(String id);
}
