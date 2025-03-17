package com.dio.spring_security.spring_security.init;

import com.dio.spring_security.spring_security.model.User;
import com.dio.spring_security.spring_security.repository.UsersRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UsersRespository repository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = repository.findByUsername("admin");
        if(user==null){
            user = new User();
            user.setName("ADMIN");
            user.setUserName("admin");
            user.setPassword(" ");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
        user = repository.findByUsername("user");
        if(user ==null){
            user = new User();
            user.setName("USER");
            user.setUserName("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            repository.save(user);
        }
    }
}