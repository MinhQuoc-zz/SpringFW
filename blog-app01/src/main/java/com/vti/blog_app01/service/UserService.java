package com.vti.blog_app01.service;

import com.vti.blog_app01.dto.UserDto;
import com.vti.blog_app01.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
}
