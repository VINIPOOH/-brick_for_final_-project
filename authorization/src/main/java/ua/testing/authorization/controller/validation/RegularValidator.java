package ua.testing.authorization.controller.validation;

import org.springframework.context.i18n.LocaleContextHolder;
import ua.testing.authorization.dto.RegistrationInfoDto;

import java.util.Locale;
import java.util.ResourceBundle;

public class RegularValidator implements RegexConstantLinks {
    private ResourceBundle regularTemplates;

    public RegularValidator(Locale locale) {
        regularTemplates =
                ResourceBundle.getBundle(
                        REGULAR_TEMPLATE_BUNDLE, locale);
    }

    public void setLocale(Locale locale) {
        regularTemplates =
                ResourceBundle.getBundle(
                        REGULAR_TEMPLATE_BUNDLE, locale);
    }

    public boolean isEmailValid(String email) {
        return email.matches(EMAIL_TEMPLATE);
    }
}
