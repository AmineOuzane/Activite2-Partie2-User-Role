package com.example.jpaenset2.service;

import com.example.jpaenset2.entities.Role;
import com.example.jpaenset2.entities.User;
import jakarta.persistence.Column;

public interface UserService {
    User addNewUser(User user);

    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);

    User authenticate(String userName, String password);
}
