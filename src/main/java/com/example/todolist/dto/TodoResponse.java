package com.example.todolist.dto;

public class TodoResponse {
    private Integer id;
    private String content;
    private boolean done;

    public TodoResponse(Integer id, String content, boolean done) {
        this.id = id;
        this.content = content;
        this.done = done;
    }

    public TodoResponse() {
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
