package com.example.webApp.model;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Builder
public class User {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;
    private final LocalDate dateOfBirth;
    private final boolean status;
}
