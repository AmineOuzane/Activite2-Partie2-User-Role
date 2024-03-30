package com.example.jpaenset2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Role {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        @Column(length = 20, unique = true)
        private String roleName;
        @Column(name = "Description")
        private String desc;
        @ManyToMany (fetch = FetchType.EAGER)
        //@JoinTable(name = "USERS_ROLES")
        @ToString.Exclude               //pour eviter une boucle ToString inclus pas users dans ToString
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //pas repeter json dans bidirectionel json controller
        private List<User> users=new ArrayList<>();
}
