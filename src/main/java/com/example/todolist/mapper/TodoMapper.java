package com.example.todolist.mapper;

import com.example.todolist.dto.TodoRequest;
import com.example.todolist.dto.TodoResponse;
import com.example.todolist.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoMapper {
    public Todo convertToEntity(TodoRequest request) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(request, todo);
        return todo;
    }

    public TodoResponse convertToResponse(Todo todo) {
        TodoResponse response = new TodoResponse();
        response.setDone(todo.isDone());
        BeanUtils.copyProperties(todo, response);
        return response;
    }

    public List<TodoResponse> convertToResponses(List<Todo> todoEntities) {
        List<TodoResponse> responses = new ArrayList<>();
        for (Todo todo : todoEntities) {
            TodoResponse response = new TodoResponse();
            response.setDone(todo.isDone());
            BeanUtils.copyProperties(todo, response);
            responses.add(response);
        }
        return responses;
    }
}
