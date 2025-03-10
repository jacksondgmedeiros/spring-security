package com.dio.spring_security.spring_security.service;

import com.dio.spring_security.spring_security.model.User;
import com.dio.spring_security.spring_security.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersRespository usersRespository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public void createUser(User user){
        String pass = user.getPassword();

        //criptografa a senha antes de salvar no banco
//        user.setPassword(passwordEncoder.encode(pass));
        usersRespository.save(user);
    }
}
