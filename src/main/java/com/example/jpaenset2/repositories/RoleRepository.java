package com.example.jpaenset2.repositories;

import com.example.jpaenset2.entities.Role;
import com.example.jpaenset2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
