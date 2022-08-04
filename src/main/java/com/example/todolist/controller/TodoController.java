package com.example.todolist.controller;

import com.example.todolist.dto.TodoRequest;
import com.example.todolist.dto.TodoResponse;
import com.example.todolist.entity.Todo;
import com.example.todolist.mapper.TodoMapper;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoMapper todoMapper;
    @GetMapping
    public List<TodoResponse> getAllTodos() {
        return todoMapper.convertToResponses(todoService.findAllTodos());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponse addTodo(@RequestBody TodoRequest request) {
        return todoMapper
                .convertToResponse(todoService.addTodo(todoMapper.convertToEntity(request)));
    }

    @PutMapping(path = "/{id}")
    public TodoResponse updateTodo(@PathVariable Integer id, @RequestBody TodoRequest request) {
        Todo todo = todoService.updateTodo(id, todoMapper.convertToEntity(request));
        return todoMapper.convertToResponse(todo);
    }

}
