package ua.testing.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import ua.testing.authorization.controller.validation.RegistrationDtoValidator;
import ua.testing.authorization.controller.validation.Validator;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class ValidationConfigure {
    @Bean
    public Validator registrationValidator() {
        return new RegistrationDtoValidator(ResourceBundle.getBundle(
                "regular_templates"
                , new Locale("en")));
    }//LocaleContextHolder.getLocale()
}