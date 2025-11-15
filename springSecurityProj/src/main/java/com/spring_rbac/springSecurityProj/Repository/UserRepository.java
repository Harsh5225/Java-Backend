package com.spring_rbac.springSecurityProj.Repository;

import com.spring_rbac.springSecurityProj.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    // optional -> Because user may or may not exist — prevents NullPointerException.
}
