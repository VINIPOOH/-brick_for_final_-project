package dto.validation;


import dto.RegistrationInfoDto;

public class RegistrationDtoValidator implements Validator<RegistrationInfoDto> {

    private static final String LOGIN_REGEX = "([A-Za-z \\d-_.]+)(@[A-Za-z]+)(\\.[A-Za-z]{2,4})";//"^([A-Za-z \\\\d-_.]+)(@[A-Za-z]+)(\\\\.[A-Za-z]{2,4})$";

    @Override
    public boolean validate(RegistrationInfoDto dto) {
        System.out.println("validation");
        //System.out.println("loginvalid"+stringParamValidate(dto.getUsername(), LOGIN_REGEX));
        System.out.println("paswordvalid" + dto.getPassword().equals(dto.getPasswordRepeat()));
        System.out.println(stringParamValidate(dto.getUsername(), LOGIN_REGEX)
                || dto.getPassword().equals(dto.getPasswordRepeat()));
        return stringParamValidate(dto.getUsername(), LOGIN_REGEX)
                || dto.getPassword().equals(dto.getPasswordRepeat());
    }


}
