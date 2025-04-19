package com.vti.blog_app01.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    private String name;
    private String username;
    private String email;
    private String password;
}
