package com.example.springBootTest.services;

import com.example.springBootTest.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUser();
    Optional<User> findUserByID(long id);
    User saveUser(User b);
    void deleteUser(long id);
    User replaceUser(User newUser, long id);
}
