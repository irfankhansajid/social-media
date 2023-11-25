package com.example.socialmediaproject.repository;

import com.example.socialmediaproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
