package com.dio.spring_security.spring_security.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

// criação do objeto para o token
public class JWTObject {
    private String subject; //nome do usuário
    private Date issuedAt; // data de criação
    private Date expiresAt; // data de expiração
    private List<String> roles; // perfil de acesso

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setRoles(String... roles){
        this.roles = Arrays.asList(roles);
    }
}
