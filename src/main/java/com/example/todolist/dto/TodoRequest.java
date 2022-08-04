package com.example.todolist.dto;

public class TodoRequest {
    private String content;

    public TodoRequest() {
    }

    public TodoRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
