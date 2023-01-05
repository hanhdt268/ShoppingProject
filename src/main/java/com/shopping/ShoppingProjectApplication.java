package com.shopping;

import com.shopping.repository.UserRepository;
import com.shopping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShoppingProjectApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShoppingProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting code");

//        User user = new User();
//        user.setAddress("Te hanh");
//        user.setEmail("hanh@gmail.com");
//        user.setUsername("hanh88");
//        user.setPassword(bCryptPasswordEncoder.encode("123"));
//        user.setPhone("0646542123");
//        user.setFullName("NguyenHanh");
//
//        Role role = new Role();
//        role.setRoleId(44L);
//        role.setRole("Admin");
//
//        Set<UserRole> roles = new HashSet<>();
//        UserRole userRole = new UserRole();
//        userRole.setUser(user);
//        userRole.setRole(role);
//
//        roles.add(userRole);
//
//        User user1 = this.userService.createUser(user, roles);
    }
}
