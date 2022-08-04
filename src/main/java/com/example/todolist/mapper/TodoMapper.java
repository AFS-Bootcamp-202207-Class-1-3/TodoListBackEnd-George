package com.example.todolist.mapper;

import com.example.todolist.dto.TodoRequest;
import com.example.todolist.dto.TodoResponse;
import com.example.todolist.entity.TodoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoMapper {
    public TodoEntity convertToEntity(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        BeanUtils.copyProperties(request, todoEntity);
        return todoEntity;
    }

    public TodoResponse convertToResponse(TodoEntity todoEntity) {
        TodoResponse response = new TodoResponse();
        BeanUtils.copyProperties(todoEntity, response);
        return response;
    }

    public List<TodoResponse> convertToResponses(List<TodoEntity> todoEntities) {
        List<TodoResponse> responses = new ArrayList<>();
        for (TodoEntity todoEntity : todoEntities) {
            TodoResponse response = new TodoResponse();
            BeanUtils.copyProperties(todoEntity, response);
            responses.add(response);
        }
        return responses;
    }
}
