package com.example.module_dev18_home_work.service;

import com.example.module_dev18_home_work.entity.User;
import com.example.module_dev18_home_work.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findById(long id){return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(id + " for user - not found!"));}
}
