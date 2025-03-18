package com.dio.spring_security.spring_security.handler;

public class CampoObrigatorioExpection extends BusinessException{
    public CampoObrigatorioExpection(String message) {
        super("O campo %s é obrigatorio", message);
    }
}
