package com.vti.blog_app01.service;

import com.vti.blog_app01.dto.PostDto;
import com.vti.blog_app01.form.PostCreateForm;
import com.vti.blog_app01.form.PostFilterForm;
import com.vti.blog_app01.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    //Phân trang
    Page<PostDto> findAllByPage(PostFilterForm form,Pageable pageable);


    Page<PostDto> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);

    PostDto findById(Long id);

    PostDto create(PostCreateForm form);

    PostDto update(PostUpdateForm form,Long id);

    void deleteById(Long id);

    void deleteByTitle(String title);

    void deleteByDesc(String description);
}
