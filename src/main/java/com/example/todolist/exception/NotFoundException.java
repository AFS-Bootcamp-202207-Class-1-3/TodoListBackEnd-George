package com.example.todolist.exception;

public class NotFoundException extends RuntimeException {
    private static final String NOT_FOUND_TODO_MESSAGE = "Not Found Such Todo";

    @Override
    public String getMessage() {
        return NOT_FOUND_TODO_MESSAGE;
    }
}
