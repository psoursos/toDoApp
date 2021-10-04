package com.example.todoapp.dao;

import com.example.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User, Long> {
}
