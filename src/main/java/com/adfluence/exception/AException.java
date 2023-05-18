package com.adfluence.exception;

public class AException extends RuntimeException{

    public AException(String message, Throwable cause){
        super(message, cause);
    }

    public AException(String message){
        super(message);
    }
}
