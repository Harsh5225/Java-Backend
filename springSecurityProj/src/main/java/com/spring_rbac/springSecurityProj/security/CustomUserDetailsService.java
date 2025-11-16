package com.spring_rbac.springSecurityProj.security;

import com.spring_rbac.springSecurityProj.Model.User;
import com.spring_rbac.springSecurityProj.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new CustomUserDetails(user);
    }

}


// Why: Spring Security calls loadUserByUsername() when someone tries to authenticate.
// Our implementation fetches the user from DB
// (via repository) and wraps it in CustomUserDetails