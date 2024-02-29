package com.difinite.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.difinite.demo.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;


public class ResponseUtils {
    
    public static ResponseEntity<String> success(Boolean status, String message, Object data) throws JsonProcessingException {
        return new ResponseEntity(
                (new ObjectMapper())
                        .setSerializationInclusion(JsonInclude.Include.ALWAYS)
                        .writeValueAsString(new Response(status, 200, message, data)),HttpStatus.OK);
    } 

    public static ResponseEntity<String> error(Boolean status, String message, Object data) throws JsonProcessingException { 
        return new ResponseEntity(
                (new ObjectMapper())
                        .setSerializationInclusion(JsonInclude.Include.ALWAYS)
                        .writeValueAsString(new Response(status, 500, message, data)),HttpStatus.INTERNAL_SERVER_ERROR);


    }

}
