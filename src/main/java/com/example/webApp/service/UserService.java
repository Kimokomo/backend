package com.example.webApp.service;


import com.example.webApp.dtos.UserDTO;
import com.example.webApp.mapper.UserMapper;
import com.example.webApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        // Map Users to UserDTOs
        return userRepository.getAllUsers()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
