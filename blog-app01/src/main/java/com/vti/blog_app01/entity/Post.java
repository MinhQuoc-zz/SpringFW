package com.vti.blog_app01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title",length = 50,nullable = false)
    private String title;

    @Column(name = "description",length = 100,nullable = false)
    private String description;

    @Column(name = "content",length = 50,nullable = false)
    private String content;

    @Column(name = "created_at",updatable = false,nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //trùng với tên biến liên kết với nó
    @OneToMany(mappedBy = "post")
    //Bài viết mà bị xóa tất cả comment bị xóa theo
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Comment> comments;

}
