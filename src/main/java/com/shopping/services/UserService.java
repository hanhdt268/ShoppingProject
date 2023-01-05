package com.shopping.services;

import com.shopping.entity.User;
import com.shopping.entity.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUsername(String username);

    //get user by id
    public User getUserById(Long userId);

    //update user
    public User updateUser(User user);

    //delete user
    public void deleteById(Long userId);
}
