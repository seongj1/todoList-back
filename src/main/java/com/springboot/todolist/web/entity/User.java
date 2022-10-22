package com.springboot.todolist.web.entity;

import com.springboot.todolist.web.dto.SignupReqDto;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Builder
    public User(Long id, String username, String password, String name, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public static User createUser(SignupReqDto signupReqDto) {
        return User.builder()
                .name(signupReqDto.getName())
                .email(signupReqDto.getEmail())
                .username(signupReqDto.getUsername())
                .password(signupReqDto.getPassword())
                .build();
    }

    public Long getId() {
        return id;
    }

}
