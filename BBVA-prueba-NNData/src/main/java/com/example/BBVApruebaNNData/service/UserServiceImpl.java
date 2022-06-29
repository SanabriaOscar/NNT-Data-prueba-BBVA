package com.example.BBVApruebaNNData.service;

import com.example.BBVApruebaNNData.model.User;
import com.example.BBVApruebaNNData.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

@Autowired
    private UserRepository userRepository;
    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
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

