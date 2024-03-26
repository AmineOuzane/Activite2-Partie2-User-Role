package com.example.jpaenset2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Role {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        private String roleName;
        private String desc;
        @ManyToMany (fetch = FetchType.EAGER)
        private List<User> users=new ArrayList<>();
}
