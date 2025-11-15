package com.spring_rbac.springSecurityProj.Repository;

import com.spring_rbac.springSecurityProj.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role>findByName(String name);


//    Why findByName()=>
//    Because when assigning roles you often do:
//    ROLE_ADMIN
//    ROLE_USER
}
