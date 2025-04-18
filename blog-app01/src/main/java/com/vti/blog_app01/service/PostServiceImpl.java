package com.vti.blog_app01.service;

import com.vti.blog_app01.dto.PostDto;
import com.vti.blog_app01.entity.Post;
import com.vti.blog_app01.form.PostCreateForm;
import com.vti.blog_app01.form.PostUpdateForm;
import com.vti.blog_app01.mapper.PostMapper;
import com.vti.blog_app01.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service

public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;


    @Override
    public List<PostDto> findAll() {
        var dtos = new LinkedList<PostDto>();
        for (Post post : postRepository.findAll()) {
            var dto = PostMapper.map(post);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Page<PostDto> findAllByPage(Pageable pageable) {
        return postRepository.findAll(pageable).map(PostMapper::map);
        // lamda
        // method reference
    }

    @Override
    public Page<PostDto> findByTitleLikeOrContentLike(String title, String content, Pageable pageable) {
        return postRepository.findByTitleLikeOrContentLike(title,content,pageable).map(PostMapper::map);
    }

    @Override
    public PostDto findById(Long id) {
        var post = postRepository.findById(id).get();
        return PostMapper.map(post);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public PostDto update(PostUpdateForm form,Long id) {
        var post = postRepository.findById(id).get();
        PostMapper.map(form, post);
        var savePost = postRepository.save(post);
        return PostMapper.map(savePost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        postRepository.deleteByTitle(title);
    }

    @Override
    @Transactional
    public void deleteByDesc(String description) {
        postRepository.deleteByDesc(description);
    }

}
