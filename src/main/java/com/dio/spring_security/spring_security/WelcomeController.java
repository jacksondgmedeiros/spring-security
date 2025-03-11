package com.dio.spring_security.spring_security;

import com.dio.spring_security.spring_security.model.User;
import com.dio.spring_security.spring_security.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WelcomeController {

    @Autowired
    private UsersRespository usersRespository;

    @GetMapping
    public String welcome() {

        return "Welcome to Spring Security";
    }
    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('MANAGERS','USERS')")
    public String users() {
        return "You are logged in";
    }

    @GetMapping("/managers")
    @PreAuthorize("hasRole('MANAGERS')")
    public String managers() {
        return "You are logged in manager";
    }

    @GetMapping("/todos")
    public List<User> getUsers(){
        return usersRespository.findAll();
    }

//    PathVariable, tras o que passou como parametro na URI
    @GetMapping("/todos/{username}")
    public User getOne(@PathVariable("username") String user){
        return usersRespository.findByUsername(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id){
        usersRespository.deleteById(id);
    }

    @PostMapping("/users")
    public User postUser(@RequestBody User user){
        usersRespository.save(user);
        return user;
    }

}
