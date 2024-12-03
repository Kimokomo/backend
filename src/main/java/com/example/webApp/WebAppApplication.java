package com.example.webApp;

import com.example.webApp.dtos.UserDTO;
import com.example.webApp.mapper.UserMapper;
import com.example.webApp.model.User;
import com.example.webApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAppApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(WebAppApplication.class, args);
    }

    @Override
    public void run(String... args) {

        UserDTO userDTO = UserDTO.builder()
                .firstName("Kimbo")
                .lastName("Slice")
                .age(25)
                .gender("m")
                .status(true)
                .dateOfBirth("22.02.1998")
                .build();

        User user = userMapper.toEntity(userDTO);
        System.out.println();
        userRepository.save(user);

    }
}
