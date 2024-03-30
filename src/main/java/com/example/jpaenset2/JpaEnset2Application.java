package com.example.jpaenset2;

import com.example.jpaenset2.entities.Role;
import com.example.jpaenset2.entities.User;
import com.example.jpaenset2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEnset2Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaEnset2Application.class, args);
    }
    @Bean       // pour que start s"execute au demarage
    CommandLineRunner start(UserService userService){
        return args -> {
            User u=new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2=new User();
            u2.setUsername("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("Student","Admin","User").forEach(r->{
                Role role1=new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user1","Student");
            userService.addRoleToUser("user1","User");
            userService.addRoleToUser("admin","User");
            userService.addRoleToUser("admin","Admin");

            try{
                    User user=userService.authenticate("user1","123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                System.out.println("Roles =>");
                user.getRoles().forEach(r->{
                    System.out.println("Roles=>"+r); //r.toString generer par lombok @Data dans entities role et user qui fait une boule infinie 'list dans list dans list'
                                                        //donc on met @ToString.Exclude dans role pour enlever users dans ToString
                });
            } catch (Exception exception){
                    exception.printStackTrace();
            }
        };
    }
}
