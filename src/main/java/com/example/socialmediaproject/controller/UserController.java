package com.example.socialmediaproject.controller;

import com.example.socialmediaproject.models.User;
import com.example.socialmediaproject.repository.UserRepository;
import com.example.socialmediaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            return user.get();
//        }
//        throw new Exception("User not found on that id " + id);

        return userService.findUserById(id);

    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userId) throws Exception {


        return userService.updateUser(user, userId);
    }

    @PutMapping("/users/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
        User user = userService.followUser(userId1, userId2);
        return user;
    }
 
    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        List<User> users = userService.searchUser(query);
        return users;
    }


}
