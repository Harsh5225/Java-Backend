package com.spring_rbac.springSecurityProj.security;


import com.spring_rbac.springSecurityProj.Model.Role;
import com.spring_rbac.springSecurityProj.Model.User;        // ✔ correct

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// Spring needs a UserDetails object that provides username, password and authorities (roles).
// This class adapts your User entity for that.
public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user){
        this.user=user;
    }

    // Convert Set<Role> -> Collection<GrantedAuthority>
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> authorities=new HashSet<>();

        if(user.getRoles()!=null){
            for(Role r: user.getRoles()){
                authorities.add(new SimpleGrantedAuthority(r.getName()));
            }
        }
        return authorities;

    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }
    @Override
    public String getUsername(){
        return user.getEmail();
    }


    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    public User getUser() {
        return this.user;
    }

}


// uses email as username
// matches your User model exactly
// roles loaded correctly