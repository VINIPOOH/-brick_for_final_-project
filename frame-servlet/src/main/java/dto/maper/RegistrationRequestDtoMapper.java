package dto.maper;

import dto.RegistrationInfoDto;

import javax.servlet.http.HttpServletRequest;

public class RegistrationRequestDtoMapper implements RequestDtoMapper<RegistrationInfoDto> {

    @Override
    public RegistrationInfoDto mapToDto(HttpServletRequest request) {
        return RegistrationInfoDto.builder()
                .username("username")
                .password("password")
                .passwordRepeat("passwordRepeat")
                .build();
    }
}
