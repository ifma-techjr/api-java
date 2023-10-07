package com.techjr.firstapi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.techjr.firstapi.models.User;
import com.techjr.firstapi.repositories.UserRepository;
import com.techjr.firstapi.dto.UserDto;
import com.techjr.firstapi.dto.UserUpdateDto;
import com.techjr.firstapi.exceptions.AppException;

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

    public User updateUser(UUID id, UserUpdateDto user) throws AppException{
        User targetUser = userRepository.findById(id).orElse(null);

        if(targetUser == null) throw new AppException("Usuário não encontrado", HttpStatus.NOT_FOUND);

        if(!user.name.isEmpty()) targetUser.setName(user.name);
        if(!user.email.isEmpty()) targetUser.setEmail(user.email);
        if(!user.password.isEmpty()) targetUser.setPassword(user.password);

        return userRepository.save(targetUser);
    }

    public User toggleAdmin(UUID id) throws AppException{
        User targetUser = userRepository.findById(id).orElse(null);

        if(targetUser == null) throw new AppException("Usuário não encontrado", HttpStatus.NOT_FOUND);

        targetUser.setAdmin(!targetUser.isAdmin());

        return userRepository.save(targetUser);
    }

    public void deleteUser(UUID id) throws AppException{
        User targetUser = userRepository.findById(id).orElse(null);

        if(targetUser == null) throw new AppException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        
        userRepository.delete(targetUser);
    }

}
