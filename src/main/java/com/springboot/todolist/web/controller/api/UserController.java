package com.springboot.todolist.web.controller.api;

import com.springboot.todolist.service.UserService;
import com.springboot.todolist.web.dto.CMRespDto;
import com.springboot.todolist.web.dto.SignupReqDto;
import com.springboot.todolist.web.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupReqDto signupReqDto) {
        User user = userService.signup(signupReqDto);
        if (user != null) {
            return new ResponseEntity<>(new CMRespDto<SignupReqDto>(1, "signup ok", signupReqDto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new CMRespDto<SignupReqDto>(0, "signup fail", signupReqDto), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/check/{username}")
    public boolean usernameCheck(@PathVariable String username) {
        return userService.usernameCheck(username);
    }
}
