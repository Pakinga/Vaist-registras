package com.spring.vaistai.service;

import com.spring.vaistai.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
