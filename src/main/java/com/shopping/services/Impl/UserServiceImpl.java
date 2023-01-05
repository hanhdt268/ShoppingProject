package com.shopping.services.Impl;

import com.shopping.entity.User;
import com.shopping.entity.UserRole;
import com.shopping.repository.RoleRepository;
import com.shopping.repository.UserRepository;
import com.shopping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there!!");
            throw new Exception();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User getUserById(Long userId) {
        return this.userRepository.findById(userId).get();
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
