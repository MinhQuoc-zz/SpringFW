package com.vti.blog_app01.service;

import com.vti.blog_app01.dto.CommentDto;
import com.vti.blog_app01.form.CommentCreateForm;
import com.vti.blog_app01.form.CommentUpdateForm;
import com.vti.blog_app01.mapper.CommentMapper;
import com.vti.blog_app01.repository.CommentRepository;
import com.vti.blog_app01.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentSercice{
    private CommentRepository commentRepository;

    private PostRepository postRepository;

    @Override
    public Page<CommentDto> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable).map(CommentMapper::map);
    }

    @Override
    public Page<CommentDto> findByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId,pageable).map(CommentMapper::map);
    }

    @Override
    public CommentDto findById(String id) {
        var comment = commentRepository.findById(id).get();
        return CommentMapper.map(comment);
    }

    @Override
    public CommentDto create(CommentCreateForm form,Long postId) {
        var comment = CommentMapper.map(form);
        var post = postRepository.findById(postId).get();
        comment.setPost(post);
        var savedComment = commentRepository.save(comment);
        return CommentMapper.map(savedComment);
    }

    @Override
    public CommentDto update(CommentUpdateForm form, String id) {
        var comment = commentRepository.findById(id).get();
        CommentMapper.map(form,comment);
        var savedComment = commentRepository.save(comment);

        return CommentMapper.map(savedComment);
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }
}
