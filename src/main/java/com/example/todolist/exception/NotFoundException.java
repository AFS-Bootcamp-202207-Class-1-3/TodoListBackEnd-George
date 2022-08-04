package com.example.todolist.exception;

import java.util.Locale;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String className) {
        super("Not Found: " + className.toLowerCase(Locale.ROOT));
    }
}
