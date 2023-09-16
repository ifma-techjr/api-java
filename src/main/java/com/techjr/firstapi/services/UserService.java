package com.techjr.firstapi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.techjr.firstapi.models.User;
import com.techjr.firstapi.repositories.UserRepository;
import com.techjr.firstapi.dto.UserDto;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public User retrieveUser(UUID id) throws Exception{
        var user = userRepository.findById(id).orElse(null);

        if(user == null) throw new Exception("Usuário não encontrado");

        return user;
    }

    public User createUser(UserDto user){
        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setAdmin(user.isAdmin());

        return userRepository.save(newUser);
    }

}
