package com.vti.blog_app01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "comment_id_gennerator",type = CommentIdGenerator.class)
    @GeneratedValue(generator = "comment_id_gennerator")
    @Column(name = "id")
    private String id;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "email",length = 75,nullable = false)
    private String email;

    @Column(name = "body",length = 100,nullable = false)
    private String body;

    //Thêm theo chỉ số(thứ tự)
    //@Enumerated(value = EnumType.ORDINAL)
    //@Enumerated(value = EnumType.STRING)
    @Convert(converter = CommentStatusConverter.class)
    private Status status;

    @Column(name = "created_at",updatable = false,nullable = false)
    @CreationTimestamp
    private LocalDateTime craetedAt;

    @Column(name = "update_at",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;

    //1-1
    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Post post;

    public enum Status{
        // 0,1,2
        REVIEW,OPEN,CLOSED
    }
}
