package com.vti.blog_app01.repository;

import com.vti.blog_app01.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {
    //findBy, countBy, deleteBy, existsBy

    Page<Post> findByTitleLikeOrContentLike(String string, String content, Pageable pageable);

    void deleteByTitle(String title);

    //cách 2 @query annotation
    //Hibernate Query Language: HQL
//    @Query("DELETE * FROM Post WHERE description = ?1 AND id = ?2")
//    void deleteByDescAndId(String description,Long id);

    //@Query("DELETE * FROM Post WHERE description = :description")
    //void deleteByDescAndId(@Param("description") String description);

    //Structured Query Language: SQL
    @Query(value = "DELETE  FROM post WHERE description = ?1",nativeQuery = true)
    @Modifying
    void deleteByDesc(String description);

    //Chú ý: khi custom Query làm thay đổi dữ liệu,Cần thêm
    //@Modifying
    //@Transactinal
}
