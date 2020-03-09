package ua.testing.authorization.controller.validation;

import java.util.Locale;
import java.util.ResourceBundle;

public class RegularValidator implements RegexConstantLinks {
    private ResourceBundle regularTemplates;

    public RegularValidator(Locale locale) {
        regularTemplates=
                ResourceBundle.getBundle(
                        REGULAR_TEMPLATE_BUNDLE, locale);
    }

    public void setLocale(Locale locale){
        regularTemplates=
        ResourceBundle.getBundle(
                REGULAR_TEMPLATE_BUNDLE, locale);
    }
    public boolean isEmailValid(String email){
        return true;
    }
}
