package com.example.webApp.controller;

import com.example.webApp.dtos.UserDTO;
import com.example.webApp.model.User;
import com.example.webApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String greet() {
        return "Welcome";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsersList() {
        return userService.getAllUsers();
    }
}
