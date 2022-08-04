package com.example.todolist.repository;

import com.example.todolist.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTodoRepository extends JpaRepository<TodoEntity, Integer> {
}
