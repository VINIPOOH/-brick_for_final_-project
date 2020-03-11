package ua.testing.authorization.controller.validation;

import ua.testing.authorization.dto.RegistrationInfoDto;

import java.util.ResourceBundle;

public class RegistrationDtoValidator implements Validator<RegistrationInfoDto>, RegexConstantLinks {

    private ResourceBundle regularTemplates;

    public RegistrationDtoValidator(ResourceBundle regularTemplates) {
        this.regularTemplates = regularTemplates;
    }

    @Override
    public boolean isValid(RegistrationInfoDto registrationInfoDto) {
        System.out.println((registrationInfoDto.getUsername().matches(EMAIL_TEMPLATE)));
        return  (registrationInfoDto.getUsername().matches(EMAIL_TEMPLATE)
                && registrationInfoDto.getPassword().equals
                (registrationInfoDto.getPasswordRepeat()));
    }
}
