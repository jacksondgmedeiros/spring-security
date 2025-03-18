package com.dio.spring_security.spring_security.service;

import com.dio.spring_security.spring_security.handler.BusinessException;
import com.dio.spring_security.spring_security.handler.CampoObrigatorioExpection;
import com.dio.spring_security.spring_security.model.User;
import com.dio.spring_security.spring_security.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersRespository usersRespository;


    public void createUser(User user){
        String pass = user.getPassword();

        if (user.getUserName()== null){
            throw new CampoObrigatorioExpection("userName");
        }

        if (user.getPassword()== null){
            throw new CampoObrigatorioExpection("password");
        }

        usersRespository.save(user);
    }
}
