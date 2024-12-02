package com.example.webApp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender; // This will store the `displayName`
    private String dateOfBirth; // Format: "dd.MM.yyyy""
    private boolean status;


}
