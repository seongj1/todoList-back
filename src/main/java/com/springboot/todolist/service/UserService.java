package com.springboot.todolist.service;

import com.springboot.todolist.repository.UserRepository;
import com.springboot.todolist.web.dto.SignupReqDto;
import com.springboot.todolist.web.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User signup(SignupReqDto signupReqDto) {
        User user = User.builder()
                .username(signupReqDto.getUsername())
                .password(signupReqDto.getPassword())
                .name(signupReqDto.getName())
                .email(signupReqDto.getEmail())
                .build();
        return userRepository.save(user);
    }

    public boolean usernameCheck(String username) {
        return userRepository.existsByUsername(username);
    }
}
