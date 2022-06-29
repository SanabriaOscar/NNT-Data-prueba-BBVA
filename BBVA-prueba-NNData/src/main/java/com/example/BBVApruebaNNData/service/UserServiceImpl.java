package com.example.BBVApruebaNNData.service;

import com.example.BBVApruebaNNData.exceptions.ResourceNotFoundException;
import com.example.BBVApruebaNNData.model.DocumentType;
import com.example.BBVApruebaNNData.model.User;
import com.example.BBVApruebaNNData.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

@Autowired
    private UserRepository userRepository;
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
    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        Optional<User> savedUser= userRepository.findById(user.getId());
        if(savedUser.isPresent()){
            new ResourceNotFoundException("User already exist with given email:" + user.getId());
        }
        user.setFirstName(userTest.getFirstName());
        user.setSecondName(userTest.getSecondName());
        user.setFirstLastName(userTest.getFirstLastName());
        user.setSecondLastName(userTest.getSecondLastName());
        user.setPhoneNumber(userTest.getPhoneNumber());
        user.setIdentification(userTest.getIdentification());
        user.setAddress(userTest.getAddress());
        user.setCity(userTest.getCity());
        user.setDocumentType(userTest.getDocumentType());
        return userRepository.save(user);
    }

    @Override
    public User findByIdUser(int id) {
        return userRepository.findById(id).get();
    }



    @Override
    public User deleteUser(int id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public List<User> searchUser(String identicationFilter) {

        User user = null;
        if (identicationFilter != null) {
            user = (User) userRepository.findUserByIdentification(identicationFilter);
        }
        return (List<User>) user;
    }

}

