package com.example.prototype.service;


import com.example.prototype.model.User;

//
public interface UserService {

    boolean save(User user);

    User findByUsername(String username);
}
