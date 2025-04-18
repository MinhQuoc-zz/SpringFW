package com.vti.blog_app01.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = PostIdExistsValidator.class
)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostIdExists {
    String message() default "{Bài viết không tồn tại theo id}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}

