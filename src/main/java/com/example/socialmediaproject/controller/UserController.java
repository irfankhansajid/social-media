package com.example.socialmediaproject.controller;

import com.example.socialmediaproject.models.User;
import com.example.socialmediaproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/{userId}")
    public User getUserId(@PathVariable("userId") Integer id) {
        User user1 = new User(1, "Irfan", "Khan", "irfankhansajid@gmail.com", "1234");
        user1.setId(id);
        return user1;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        User savedUser = userRepository.save(newUser);
        return savedUser;
    }
    
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        User user1 = new User(1, "Irfan", "Khan", "irfankhansajid@gmail.com", "1234");

        if(user.getFirstName() != null) {
            user1.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            user1.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            user1.setEmail(user.getEmail());
        }
        return user1;
    }
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) {
        return "User deleted successfully by id "+ id;
    }
}
