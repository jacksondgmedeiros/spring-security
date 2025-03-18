package com.dio.spring_security.spring_security.controller;

import com.dio.spring_security.spring_security.model.User;
import com.dio.spring_security.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/controller")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void postUser(@RequestBody User user) {
        userService.createUser(user);

    }

}
