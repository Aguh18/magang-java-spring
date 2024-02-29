package com.difinite.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    
    private Boolean status;
    private Integer code;
    private String message;
    private Object data;
}
