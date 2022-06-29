package com.example.BBVApruebaNNData.controller;

import com.example.BBVApruebaNNData.model.DocumentType;
import com.example.BBVApruebaNNData.model.User;
import com.example.BBVApruebaNNData.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    User userTest =new User(1,
            "oscar",
            "jesus",
            "sanabria",
            "tavera",
            31329746,
            23445322,
            "calle-40",
            "kennedy" ,
            new DocumentType(1,"P"));

    @GetMapping("/users/searchUser")
    public ResponseEntity<List<User>> searchUserC(@Param("identicationFilter") String filter) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.searchUser(filter));
        }catch (Exception e){
            return (ResponseEntity<List<User>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<User> listAllUsers() {
        List<User> users = userService.listAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping("/users/add")
    public ResponseEntity<User> saveUserC(@RequestBody User user){
     try {
         user.setFirstName(userTest.getFirstName());
         user.setSecondName(userTest.getSecondName());
         user.setFirstLastName(userTest.getFirstLastName());
         user.setSecondLastName(userTest.getSecondLastName());
         user.setPhoneNumber(userTest.getPhoneNumber());
         user.setIdentification(userTest.getIdentification());
         user.setAddress(userTest.getAddress());
         user.setCity(userTest.getCity());
         user.setDocumentType(userTest.getDocumentType());
         userService.saveUser(user);
     }catch (Exception e){
         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     }
        return new ResponseEntity<User>(user, null, HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> listUserByIdC(@PathVariable int id) {
        User user= userService.findByIdUser(id);
        if (null == user) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @PutMapping("/users/edit/{id}")
    public ResponseEntity<User> updateUserByIdC(@PathVariable int id, @RequestBody User user) {
       try {
           User userUpdate = userService.findByIdUser(id);
           if (null == userUpdate) {
               return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
           }
           userUpdate.setFirstName(userUpdate.getFirstName());
           userUpdate.setSecondName(user.getSecondName());
           userUpdate.setFirstLastName(user.getFirstLastName());
           userUpdate.setSecondLastName(user.getSecondLastName());
           userUpdate.setPhoneNumber(user.getPhoneNumber());
           userUpdate.setIdentification(user.getIdentification());
           userUpdate.setAddress(user.getAddress());
           userUpdate.setCity(user.getCity());
           userService.saveUser(userUpdate);
           return new ResponseEntity<User>(userUpdate, HttpStatus.OK);
       }catch (Exception e){
            new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
           e.printStackTrace();
       }
        return (ResponseEntity<User>) ResponseEntity.ok();
    }
    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<User> deleteUserC(@PathVariable int id){
     User user= userService.findByIdUser(id);
        if (null == user) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
         userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
