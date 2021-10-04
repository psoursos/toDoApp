package com.example.todoapp.dao;

import com.example.todoapp.model.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ToDoRepo extends JpaRepository<ToDoTask,Long> {
}
