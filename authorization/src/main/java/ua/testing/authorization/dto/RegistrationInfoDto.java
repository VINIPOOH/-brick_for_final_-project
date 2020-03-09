package ua.testing.authorization.dto;

import lombok.Data;

@Data
public class RegistrationInfoDto {
    private String username;
    private String password;
    private String passwordRepeat;
}