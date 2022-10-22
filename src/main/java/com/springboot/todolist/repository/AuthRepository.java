package com.springboot.todolist.repository;

import com.springboot.todolist.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, String> {
}
