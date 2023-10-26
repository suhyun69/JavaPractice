package com.example.demo.exception;

public class AuthFailException extends RuntimeException{
    public AuthFailException(String message) {
        super(message);
    }
}