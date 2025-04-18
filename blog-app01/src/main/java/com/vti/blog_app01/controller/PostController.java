package com.vti.blog_app01.controller;

import com.vti.blog_app01.dto.PostDto;
import com.vti.blog_app01.form.PostCreateForm;
import com.vti.blog_app01.form.PostFilterForm;
import com.vti.blog_app01.form.PostUpdateForm;
import com.vti.blog_app01.mapper.PostMapper;
import com.vti.blog_app01.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class PostController {
    @Autowired
    private PostService postService;

//    @GetMapping("/api/v1/posts")
//    public List<PostDto> findAll(){
//        return postService.findAll();
//    }

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAllByPage(PostFilterForm form,Pageable pageable){
        return postService.findAllByPage(form,pageable);
    }

    @GetMapping("/api/v1/posts/title/{title}/content/{content}")
    public Page<PostDto> findByTitleLikeOrContent(@PathVariable("title") String title,@PathVariable("content") String content, Pageable pageable){
      return postService.findByTitleLikeOrContentLike("%" + title + "%","%" + content + "%",pageable);
    }


    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id")  Long id){
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/posts")
    public PostDto create(@Valid  @RequestBody PostCreateForm form){
        return postService.create(form);
    }

    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(@RequestBody PostUpdateForm form,@PathVariable("id") Long id){
        return postService.update(form,id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") Long id){
        postService.deleteById(id);
    }

    @DeleteMapping("/api/v1/posts/title/{title}")
    public void deleteByTitle(@PathVariable("title") String title){
        postService.deleteByTitle(title);
    }

    @DeleteMapping("/api/v1/posts/desc/{description}")
    public void deleteByDesc(@PathVariable("description") String description){
        postService.deleteByDesc(description);
    }
}
