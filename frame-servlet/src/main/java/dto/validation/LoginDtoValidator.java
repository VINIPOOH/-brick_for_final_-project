package dto.validation;


import dto.LoginInfoDto;
import dto.RegistrationInfoDto;

public class LoginDtoValidator implements Validator<LoginInfoDto> {

    private static final String LOGIN_REGEX = "([A-Za-z \\d-_.]+)(@[A-Za-z]+)(\\.[A-Za-z]{2,4})";//"^([A-Za-z \\\\d-_.]+)(@[A-Za-z]+)(\\\\.[A-Za-z]{2,4})$";

    @Override
    public boolean validate(LoginInfoDto dto) {
        return stringParamValidate(dto.getUsername(), LOGIN_REGEX);
    }


}
