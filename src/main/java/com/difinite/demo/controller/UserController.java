package com.difinite.demo.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import com.difinite.demo.dto.AddUserDTO;
import com.difinite.demo.service.UserService;
import com.difinite.demo.util.ResponseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


@GetMapping("/list")
public ResponseEntity<String> getUserList() throws JsonProcessingException {

    return userService.getUserList();
    
}

@GetMapping("/detail")
public ResponseEntity<String> getUserByid( @RequestParam(name = "idUser") String id ) throws JsonProcessingException {

    try {
        return  userService.getUserByid(id);
    } catch (Exception e) {
        return ResponseUtils.error(false, "Error code S", null);
    }
    
}

@PostMapping("/add")
public ResponseEntity<String> addUser(@RequestBody AddUserDTO addUserDTO) throws JsonProcessingException {

    try {
        return userService.addUser(addUserDTO);
    } catch (Exception e) {
        return ResponseUtils.error(false, "Error code S", null);
    }

    
}
@PutMapping("/update/{idUser}")
public ResponseEntity<String> updateUser(@PathVariable( name = "idUser" ) int idUser, @RequestBody AddUserDTO addUserDTO) throws JsonProcessingException {

    return userService.updateUser(idUser, addUserDTO);



}
@DeleteMapping("/delete")
public ResponseEntity<String> deleteUserById(@RequestParam(name = "idUser") String id) throws JsonProcessingException, NumberFormatException {

    return userService.deleteUser(Integer.parseInt(id));
}

@DeleteMapping("/softdelete")
public ResponseEntity<String> softDelete(@RequestParam(name = "idUser") String id) throws JsonProcessingException, NumberFormatException {

    return userService.softDelete(Integer.parseInt(id));


}
}
