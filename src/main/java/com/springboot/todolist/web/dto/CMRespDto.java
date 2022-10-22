package com.springboot.todolist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CMRespDto<T> {

    private int code;
    private String meg;
    private T data;
}
