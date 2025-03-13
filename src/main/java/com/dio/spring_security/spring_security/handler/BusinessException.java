package com.dio.spring_security.spring_security.handler;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    // conteudo dinamico
    public BusinessException(String message, Object... params) {
        super(String.format(message, params));
    }
}
