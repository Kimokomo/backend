package com.example.webApp.repositories;

import com.example.webApp.model.Gender;
import com.example.webApp.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(User.builder().id(1L).firstName("Alice").lastName("Wonderland").age(25).gender(Gender.FEAMLE).status(true).dateOfBirth(LocalDate.now()).build());
        users.add(User.builder().id(2L).firstName("Baumeister").lastName("Bob").age(30).gender(Gender.MALE).status(false).build());
        users.add(User.builder().id(3L).firstName("Charlie").lastName("Cheen").age(35).gender(Gender.MALE).status(true).build());
        users.add(User.builder().id(4L).firstName("Slice").lastName("Kimbo").age(26).gender(Gender.OTHER).status(false).build());
        users.add(User.builder().id(5L).firstName("Mohamed").lastName("Yassin").age(26).gender(Gender.MALE).status(true).build());
        users.add(User.builder().id(6L).firstName("Atef").lastName("Farghal").age(26).gender(Gender.MALE).status(true).build());
        users.add(User.builder().id(7L).firstName("Mona").lastName("Osman").age(26).gender(Gender.FEAMLE).status(false).build());
        users.add(User.builder().id(8L).firstName("Slice").lastName("Kimbo").age(26).gender(Gender.MALE).status(true).build());
        users.add(User.builder().id(9L).firstName("Dina").lastName("Yassin").age(27).gender(Gender.FEAMLE).status(false).build());
        users.add(User.builder().id(10L).firstName("Abdallah").lastName("Radwan").age(28).gender(Gender.MALE).status(true).build());
        users.add(User.builder().id(11L).firstName("Elias").lastName("Radwan").age(1).gender(Gender.MALE).status(true).build());
        users.add(User.builder().id(12L).firstName("Noah").lastName("Radwan").age(4).gender(Gender.MALE).status(true).build());
        System.out.println();
    }

    public List<User> getAllUsers() {

        return users;
    }
}
