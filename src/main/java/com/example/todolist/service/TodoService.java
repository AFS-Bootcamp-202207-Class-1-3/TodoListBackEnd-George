package com.example.todolist.service;


import com.example.todolist.entity.TodoEntity;
import com.example.todolist.repository.JpaTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private JpaTodoRepository jpaTodoRepository;
    public List<TodoEntity> findAllTodos() {
        return jpaTodoRepository.findAll();
    }
}
