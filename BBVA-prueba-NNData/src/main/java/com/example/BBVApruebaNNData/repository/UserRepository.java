package com.example.BBVApruebaNNData.repository;

import com.example.BBVApruebaNNData.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
