package com.example.springnotification.repository;

import com.example.springnotification.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {

}
