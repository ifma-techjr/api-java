package com.techjr.firstapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techjr.firstapi.models.User;
import com.techjr.firstapi.services.UserService;

import jakarta.validation.Valid;

import com.techjr.firstapi.dto.UserDto;
import com.techjr.firstapi.dto.UserUpdateDto;
import com.techjr.firstapi.exceptions.AppException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        List<User> users = userService.listUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        try {
            User user = userService.retrieveUser(uuid);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody @Valid UserUpdateDto user) throws AppException{
        UUID uuid = UUID.fromString(id);
        try {
            User updatedUser = userService.updateUser(uuid, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            throw new AppException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> toggleAdmin(@PathVariable String id) throws AppException{
        UUID uuid = UUID.fromString(id);
        try {
            User updatedUser = userService.toggleAdmin(uuid);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            throw new AppException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) throws AppException{
        UUID uuid = UUID.fromString(id);
        try {
            userService.deleteUser(uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new AppException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
