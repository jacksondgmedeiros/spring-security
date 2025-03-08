package com.dio.spring_security.spring_security.repository;

import com.dio.spring_security.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRespository extends JpaRepository<User, Integer> {

    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.userName = (:username)")
    public User findByUsername(@Param("username") String username);

}
