package com.difinite.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.difinite.demo.domain.UserDomain;
import com.difinite.demo.dto.AddUserDTO;
import com.difinite.demo.repository.UserRepository;
import com.difinite.demo.util.ResponseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    


public ResponseEntity<String> getUserList( ) throws JsonProcessingException {
    
    try {
       
        List<UserDomain>  dataUser = userRepository.getUserList();

        return ResponseUtils.success(true, "data berhasil", dataUser);

    } catch (Exception e) {
        return  ResponseUtils.error(false, "Error code S", null);
    }

   
    
}

public ResponseEntity<String> getUserByid( @RequestParam(name = "idUser") String id ) throws JsonProcessingException {

    try {
        
        Optional<UserDomain> dataUser = userRepository.getUserById(Integer.parseInt(id));
        return ResponseUtils.success(true, "Data User", dataUser.get());
    } catch (Exception e) {
        return ResponseUtils.error(false, "Error code S", null);
    }
    
}

public ResponseEntity<String> addUser(@RequestBody AddUserDTO addUserDTO) {

    UserDomain user = new UserDomain();


    try {
        user.setFullName(addUserDTO.getFullName());
        user.setGender(addUserDTO.getGender());
        // user.setCreatedAt(null);
       
        userRepository.save(user);
        return ResponseUtils.success(true, "Data User", user);
        
    } catch (Exception e) {
        System.out.println(e);
    }


 

   
    return null;

    
}

public ResponseEntity<String> updateUser(@PathVariable( name = "idUser" ) int idUser, @RequestBody  AddUserDTO addUserDTO) throws JsonProcessingException {

    try {
        System.out.println(addUserDTO.getFullName()+ idUser);
        
        userRepository.updateFullNameById(idUser, addUserDTO.getFullName());
        Optional<UserDomain> userUpdate = userRepository.getUserById(idUser);
        return ResponseUtils.success(true, "Data berhasil diupdate", userUpdate.get());
        
        
    } catch (Exception e) {
       return ResponseUtils.error(false, e.toString(), null);
    }



}

public ResponseEntity<String> deleteUser(@PathVariable( name = "idUser" ) int idUser) throws JsonProcessingException {

    try {
        Optional<UserDomain> userDelete = userRepository.getUserById(idUser);
       userRepository.deleteById(idUser);
       return ResponseUtils.success(true, "Data berhasil dihapus", userDelete.get());
    } catch (Exception e) {
        return ResponseUtils.error(false, "data tidak berhasil dihapis", null);
        
}
}

public ResponseEntity<String> softDelete(@RequestParam(name = "idUser") Integer id) throws JsonProcessingException  {

    try {
        userRepository.softDelete(id);
        Optional<UserDomain> userDelete = userRepository.getUserById(id);
      
        return ResponseUtils.success(true, "Data berhasil dihapus", userDelete.get());
        
    } catch (Exception e) {
        return ResponseUtils.error(false, e.toString(), null);
    }

    


}
}
