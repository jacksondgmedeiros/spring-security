package com.dio.spring_security.spring_security.config;

import com.dio.spring_security.spring_security.model.User;
import com.dio.spring_security.spring_security.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityDataBaseService implements UserDetailsService {
    @Autowired
    private UsersRespository usersRespository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = usersRespository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role -> {
           grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), grantedAuthorities);

        return userDetails;
    }
}
