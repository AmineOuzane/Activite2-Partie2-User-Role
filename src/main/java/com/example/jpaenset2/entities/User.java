package com.example.jpaenset2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name= "USER_NAME",unique = true, length = 20)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //pour pas afficher mdp dans file json
    private String password;
    @ManyToMany (mappedBy = "users",fetch = FetchType.EAGER) // CHARGE USERS AVEC LEUR ROLE AUSSI
    private List<Role> roles=new ArrayList<>(); // EAGER --> ArrayList pour eviter null pointer
}
