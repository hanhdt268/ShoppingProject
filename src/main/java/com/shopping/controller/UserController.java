package com.shopping.controller;

import com.shopping.entity.Role;
import com.shopping.entity.User;
import com.shopping.entity.UserRole;
import com.shopping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //create user
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRole("Client");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return ResponseEntity.ok(this.userService.createUser(user, roles));
    }

    //get user by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUsername(username);
    }

    //update username
    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User u = this.userService.getUserById(user.getId());
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(u);
        } else {
            user.setUserRoles(u.getUserRoles());
            return ResponseEntity.ok(this.userService.updateUser(user));
        }
    }

    //delete by id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.userService.deleteById(id);
    }
}
