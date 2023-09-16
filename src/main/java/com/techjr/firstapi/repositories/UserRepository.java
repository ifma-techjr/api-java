package com.techjr.firstapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techjr.firstapi.models.User;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

    User findByEmail(String email);
    
}
