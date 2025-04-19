package com.vti.blog_app01.repository;

import com.vti.blog_app01.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByType(Role.Type type);
}
