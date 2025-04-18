package com.vti.blog_app01.validation;

import com.vti.blog_app01.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class PostIdExistsValidator implements ConstraintValidator<PostIdExists,Long> {
    @Autowired
    private PostRepository postRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return postRepository.existsById(id);
    }
}
