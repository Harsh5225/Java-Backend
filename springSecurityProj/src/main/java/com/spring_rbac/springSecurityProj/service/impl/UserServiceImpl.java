package com.spring_rbac.springSecurityProj.service.impl;

import com.spring_rbac.springSecurityProj.Model.User;
import com.spring_rbac.springSecurityProj.Repository.UserRepository;
import com.spring_rbac.springSecurityProj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
