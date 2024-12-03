package com.example.webApp.mapper;

import com.example.webApp.dtos.UserDTO;
import com.example.webApp.model.Gender;
import com.example.webApp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "gender", source = "gender.displayName")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "formatLocalDate")
    @Mapping(target = "status", source = "status")
    UserDTO toDto(User user);

    @Mapping(target = "gender", source = "gender", qualifiedByName = "stringToGender")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "parseDateOfBirth")
    User toEntity(UserDTO userDTO);

    @Named("formatLocalDate")
    default String formatLocalDate(LocalDate date) {
        if (date == null) return null;
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Named("genderToString")
    default String genderToString(Gender gender) {
        if (gender == null) return null;
        return gender.getDisplayName();
    }

    @Named("stringToGender")
    default Gender stringToGender(String genderDisplayName) {
        if (genderDisplayName == null) return null;
        switch (genderDisplayName) {
            case "m":
                return Gender.MALE;
            case "f":
                return Gender.FEAMLE;
            case "o":
                return Gender.OTHER;
            default:
                throw new IllegalArgumentException("Unknown gender display name: " + genderDisplayName);
        }
    }

    @Named("parseDateOfBirth")
    default LocalDate parseDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) return null;
        return LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
