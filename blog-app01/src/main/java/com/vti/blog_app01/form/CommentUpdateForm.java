package com.vti.blog_app01.form;

import com.vti.blog_app01.entity.Comment;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentUpdateForm {
    @NotBlank(message = "Tên ko được để trống")
    @Length(message = "Tên tối đa 50 ký tự",max = 50)
    private String name;

    @NotBlank(message = "Email ko được để trống")
    @Length(message = "Tên tối đa 100 ký tự",max = 100)
    @Email(message = "Email ko đúng định dạng")
    private String email;

    @NotBlank(message = "Body ko được để trống")
    @Length(message = "body tối đa 150 ký tự",max = 150)
    private String body;


    @NotNull(message = "Status ko được để trống")
    private Comment.Status status;
}
