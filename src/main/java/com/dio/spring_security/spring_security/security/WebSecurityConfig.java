package com.dio.spring_security.spring_security.security;

import com.dio.spring_security.spring_security.config.SecurityDataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//classe de configuração
@Configuration
public class WebSecurityConfig {

    @Autowired
    private SecurityDataBaseService securityDataBaseService;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityDataBaseService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    // Bean que é para o spring conseguir gerenciar e injetar se necessário
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //authorizeHttpRequests para mostrar qual é a url acessada, nesse caso, tudo liberado
                .authorizeHttpRequests(
                 auth -> auth
                         .requestMatchers("/").permitAll()
                         .requestMatchers("/login").permitAll()
                         // pagina que pode ser acessada com a permissão managers
                         .requestMatchers("/users").hasAnyRole("USERS","MANAGERS")
                         //liberado para todos, porém, só GET
                         .requestMatchers(HttpMethod.GET, "/managers").hasRole("MANAGERS")
                         // diz que qualquer outra precisa tá autenticada
                         .anyRequest().authenticated()


                ).httpBasic(Customizer.withDefaults())
                // desativa o cors
                .csrf(AbstractHttpConfigurer::disable)
                // a sessão é stateless, ou seja, não guarda sessão
                .sessionManagement(
                        session ->
                                session.sessionCreationPolicy((SessionCreationPolicy.STATELESS))
                );
        //compila o http
        return http.build();
    }

    /*
    @Bean
    public UserDetailsService userDetailsService() {
        // para definir um usuário
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("MANAGERS")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }*/



}
