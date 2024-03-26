package com.example.jpaenset2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "USERS")

public class User {
    @Id
    private String userId;
    private String username;
    private String password;
    @ManyToMany (mappedBy = "users",fetch = FetchType.EAGER) // CHARGE USERS AVEC LEUR ROLE AUSSI
    private List<Role> roles=new ArrayList<>(); // EAGER --> ArrayList pour eviter null pointer
}
