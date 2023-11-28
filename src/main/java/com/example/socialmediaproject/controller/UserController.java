package com.example.socialmediaproject.controller;

import com.example.socialmediaproject.models.User;
import com.example.socialmediaproject.repository.UserRepository;
import com.example.socialmediaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserId(@PathVariable("userId") Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new Exception("User not found on that id " + id);

    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userId) throws Exception {
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new Exception("User not exit with id " + id);
        }
        userRepository.delete((user.get()));

        return "User deleted successfully by id " + id;
    }
}
