package com.springboot.service;

import com.springboot.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void insertUser();
}
