package com.vti.blog_app01.repository;

import com.vti.blog_app01.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentRepository extends JpaRepository<Comment,String>, JpaSpecificationExecutor<Comment> {
    Page<Comment> findByPostId(Long postId, Pageable pageable);

    //Search, minCreatedDate, maxCreatedDate

}
