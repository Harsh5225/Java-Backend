package com.spring_rbac.springSecurityProj.Controller;

import com.spring_rbac.springSecurityProj.Model.User;
import com.spring_rbac.springSecurityProj.dto.RegisterRequest;
import com.spring_rbac.springSecurityProj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    public String register(@RequestBody RegisterRequest request){
        User user=userService.registerNewUser(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        if(user==null){
            return "User already exists with email: " + request.getEmail();
        }
        return "User registered successfully with email: " + user.getEmail();
    }
}
