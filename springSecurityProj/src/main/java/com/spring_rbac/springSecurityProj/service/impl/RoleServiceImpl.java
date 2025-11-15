package com.spring_rbac.springSecurityProj.service.impl;

import com.spring_rbac.springSecurityProj.Model.Role;
import com.spring_rbac.springSecurityProj.Repository.RoleRepository;
import com.spring_rbac.springSecurityProj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
   private RoleRepository roleRepository;


    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


}
