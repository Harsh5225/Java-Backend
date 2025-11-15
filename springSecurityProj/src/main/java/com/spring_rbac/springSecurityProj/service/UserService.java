package com.spring_rbac.springSecurityProj.service;

import com.spring_rbac.springSecurityProj.Model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User getUserByUsername(String username);
    List<User>getAllUsers();
}
