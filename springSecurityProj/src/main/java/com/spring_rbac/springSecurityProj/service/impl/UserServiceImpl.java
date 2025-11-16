package com.spring_rbac.springSecurityProj.service.impl;

import com.spring_rbac.springSecurityProj.Model.Role;
import com.spring_rbac.springSecurityProj.Model.User;
import com.spring_rbac.springSecurityProj.Repository.RoleRepository;
import com.spring_rbac.springSecurityProj.Repository.UserRepository;
import com.spring_rbac.springSecurityProj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
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


    @Override
    public User registerNewUser(String name, String email, String password) {
        if(userRepository.findByEmail(email).isPresent()){
            return  null;
        }

        // get ROLE_USER from DB OR create if not exists
        Role userRole=roleRepository.findByName("ROLE_UESR")
                .orElseGet(()-> roleRepository.save(new Role("ROLE_USER")));


        // encode password
        String encodedPassword=passwordEncoder.encode(password);

        // prepares roles set;
        Set<Role>roles=new HashSet<>();
        roles.add(userRole);

        User newUser=new User(name,email,encodedPassword,roles);
        return userRepository.save(newUser);

    }

}
