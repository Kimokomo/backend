package com.example.webApp;

import com.example.webApp.model.Gender;
import com.example.webApp.model.User;
import com.example.webApp.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class WebAppApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebAppApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // Erstelle eine neue Entity
        User user = User.builder()
                .firstName("Kimbo")
                .lastName("Slice")
                .age(25)
                .gender(Gender.MALE)
                .status(false)
                .dateOfBirth(LocalDate.now())
                .build();

        userRepository.save(user);

        // Get all users from the repository
        List<User> users = userRepository.getAllUsers();
        System.out.println("All users: " + users);


        // Find a user by ID
        Long userId = user.getId();  // Assuming the user was saved and has an ID
        Optional<User> foundUser = userRepository.findById(userId);
        foundUser.ifPresentOrElse(
                u -> System.out.println("User found: " + u),
                () -> System.out.println("User with ID " + userId + " not found.")
        );

        // Close the repository (this will close EntityManagerFactory)
        userRepository.close();
    }
}
