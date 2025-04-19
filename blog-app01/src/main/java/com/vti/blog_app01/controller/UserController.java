package com.vti.blog_app01.controller;

import com.vti.blog_app01.dto.UserDto;
import com.vti.blog_app01.form.UserCreateForm;
import com.vti.blog_app01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/users")
    public UserDto create(@RequestBody UserCreateForm form){
        return userService.create(form);
    }
}
