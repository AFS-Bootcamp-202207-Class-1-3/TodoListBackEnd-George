package com.example.todolist.dto;

public class TodoRequest {
    private String content;

    private Boolean done;

    public TodoRequest() {
    }

    public TodoRequest(String content, Boolean done) {
        this.content = content;
        this.done = done;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
