package com.example.todolist.service;


import com.example.todolist.dto.TodoResponse;
import com.example.todolist.entity.Todo;
import com.example.todolist.exception.NotFoundException;
import com.example.todolist.repository.JpaTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private JpaTodoRepository jpaTodoRepository;

    public List<Todo> findAllTodos() {
        return jpaTodoRepository.findAll();
    }

    public Todo addTodo(Todo todo) {
        return jpaTodoRepository.save(todo);
    }

    public Todo updateTodo(Integer id, Todo updateTodo) {
        Todo oldTodo = jpaTodoRepository.findById(id).orElseThrow(NotFoundException::new);
        oldTodo.updateTodo(updateTodo);
        return jpaTodoRepository.save(oldTodo);
    }

    public void deleteTodo(Integer id) {
        jpaTodoRepository.deleteById(id);
    }
}
