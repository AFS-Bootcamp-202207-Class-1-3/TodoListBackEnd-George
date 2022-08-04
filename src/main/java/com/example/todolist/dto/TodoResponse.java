package com.example.todolist.dto;

public class TodoResponse {
    private Integer id;
    private String content;
    private Boolean done;

    public TodoResponse() {
    }

    public TodoResponse(Integer id, String content, Boolean done) {
        this.id = id;
        this.content = content;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
