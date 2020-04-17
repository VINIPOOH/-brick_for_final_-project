package controller.comand.action.impl;

import controller.comand.action.MultipleMethodCommand;
import dto.LoginInfoDto;
import dto.maper.RequestDtoMapper;
import dto.validation.Validator;
import entity.User;
import exeptions.NoSuchUserException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static controller.constants.AttributeConstants.SESSION_USER;
import static controller.constants.DataForPageNamedConstant.INCORRECT_LOGIN_OR_PASSWORD;
import static controller.constants.PageConstance.LOGIN_PATH;
import static controller.constants.PageConstance.REDIRECT_ON_HOME;

public class Login extends MultipleMethodCommand {

    private final Validator<LoginInfoDto> loginDtoValidator;
    private final RequestDtoMapper<LoginInfoDto> loginInfoDtoRequestDtoMapper;
    private final UserService userService;

    public Login(Validator<LoginInfoDto> loginDtoValidator, RequestDtoMapper<LoginInfoDto> loginInfoDtoRequestDtoMapper, UserService userService) {
        this.loginDtoValidator = loginDtoValidator;
        this.loginInfoDtoRequestDtoMapper = loginInfoDtoRequestDtoMapper;
        this.userService = userService;
    }

    @Override
    protected String performGet(HttpServletRequest request) {
        return LOGIN_PATH;
    }

    @Override
    protected String performPost(HttpServletRequest request) {

        LoginInfoDto loginInfoDto = loginInfoDtoRequestDtoMapper.mapToDto(request);
        if (loginDtoValidator.isValid(loginInfoDto)) {
            try {
                Optional<User> user = userService.loginUser(loginInfoDto);
                if (user.isPresent()) {
                    request.getSession().setAttribute(SESSION_USER, user.get());
                    return REDIRECT_ON_HOME;
                }
            } catch (NoSuchUserException ignored) {
            }
        }
        request.setAttribute(INCORRECT_LOGIN_OR_PASSWORD, true);
        return LOGIN_PATH;
    }
}