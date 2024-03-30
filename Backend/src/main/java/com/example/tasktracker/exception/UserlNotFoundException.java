package com.example.tasktracker.exception;

public class UserlNotFoundException extends RuntimeException{
    public UserlNotFoundException(String message) {
        super(message);
    }
}
