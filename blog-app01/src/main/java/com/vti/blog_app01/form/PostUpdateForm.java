package com.vti.blog_app01.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostUpdateForm {
    @NotBlank(message = "Tiêu đề bài viết ko được để trống")
    @Length(max = 50,message = "Tối đa 50 ký tự")
    private String title;

    @NotBlank(message = "Mô tả bài viết ko được để trống")
    @Length(max = 100,message = "Tối đa 100 ký tự")
    private String description;

    @NotBlank(message = "Nội dung bài viết ko được để trống")
    @Length(max = 150,message = "Tối đa 150 ký tự")
    private String content;

}
