package com.spring_rbac.springSecurityProj.service;

import com.spring_rbac.springSecurityProj.Model.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
}
