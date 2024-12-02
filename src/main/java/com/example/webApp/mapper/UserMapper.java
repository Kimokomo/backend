package com.example.webApp.mapper;

import com.example.webApp.dtos.UserDTO;
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

    @Named("formatLocalDate")
    default String formatLocalDate(LocalDate date) {
        if (date == null) return null;
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
