package com.vti.blogapp.controller;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController // Tầng controller và có dữ liệu trả về
public class PostController {
    private PostService postService;

    //Thiết kế API
    //http://com.vti/api/v1/posts + HTTP method
    @PostMapping("/api/v1/posts")

    public PostDto create(@RequestBody PostCreateForm form){
        return postService.create(form);
    }
}
