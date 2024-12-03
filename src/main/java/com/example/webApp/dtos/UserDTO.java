package com.example.webApp.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String dateOfBirth;
    private boolean status;


}
