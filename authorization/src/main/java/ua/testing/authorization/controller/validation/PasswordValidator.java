package ua.testing.authorization.controller.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;

public class PasswordValidator {

    public static boolean checkEqualsRepeatedPassword(@NotNull String password,@NotNull String repeatedPassword){
        return password.equals(repeatedPassword);
    }

}
