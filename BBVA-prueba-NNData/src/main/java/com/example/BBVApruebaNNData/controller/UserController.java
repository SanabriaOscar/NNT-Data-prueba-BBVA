package com.example.BBVApruebaNNData.controller;

import com.example.BBVApruebaNNData.model.User;
import com.example.BBVApruebaNNData.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/users")
    public List<User> listAllUserC(){
        return userService.listAllUsers();
    }

    @PostMapping("/users/add")
    public String saveUserC(@RequestBody User user){
        userService.saveUser(user);
        return "User saved sussesfull";
    }
    @GetMapping("/users/{id}")
    public User listUserByIdC(@PathVariable int id) {
        return userService.findByIdUser(id);
    }
    @PutMapping("/users/edit/{id}")
    public User updateUserByIdC(@PathVariable int id, @RequestBody User user) {
        User userUpdate= userService.findByIdUser(id);
        userUpdate.setFirstName(userUpdate.getFirstName());
        userUpdate.setSecondName(user.getSecondName());
        userUpdate.setFirtLastName(user.getFirstLastName());
        userUpdate.setSecondLastName(user.getSecondLastName());
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userUpdate.setIdentification(user.getIdentification());
        userUpdate.setAddress(user.getAddress());
        userUpdate.setCity(user.getCity());
        return userService.saveUser(userUpdate);
    }
    @DeleteMapping("/users/delete/{id}")
    public String deleteUserC(@PathVariable int id){
        userService.deleteUser(id);
        return "User deleted sussesfull";
    }

}
