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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "username",length = 25,unique = true,nullable = false)
    private String username;

    @Column(name = "email",length = 100,unique = true,nullable = false)
    private String email;

    @Column(name = "password",length = 100,nullable = false)
    private String password;

    @Column(name = "created_at",updatable = false,nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
