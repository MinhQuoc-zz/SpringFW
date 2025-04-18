package com.vti.blogapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity //ánh xạ tương ứng với 1 bảng trong Database
@Table(name = "post")
public class Post {
    @Id //tự định nghĩa khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Tự động tăng
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 50,nullable = false )// NOT NULL
    private String title;

    @Column(name = "description", length = 150, nullable = false)
    private String description;

    @Column(name = "content",length = 150,nullable = false)
    private String content;

    @Column(name = "create_at",updatable = false,nullable = false)
    @CreationTimestamp //lấy thời gian hiện tại là thời gian tạo
    private LocalDateTime createdAt;

    @Column(name = "update_at",nullable = false)
    @UpdateTimestamp //lấy thời gian lúc đấy là thời gian cập nhật
    private LocalDateTime updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
