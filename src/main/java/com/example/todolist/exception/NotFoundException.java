package com.example.todolist.exception;

public class NotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "not found such todo";
    }
}
