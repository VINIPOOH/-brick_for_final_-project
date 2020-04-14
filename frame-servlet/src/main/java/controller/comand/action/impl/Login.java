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
        return "/WEB-INF/login.jsp";
    }

    @Override
    protected String performPost(HttpServletRequest request) {

        LoginInfoDto loginInfoDto = loginInfoDtoRequestDtoMapper.mapToDto(request);
        if (loginDtoValidator.validate(loginInfoDto)){
            try {
                System.out.println("pre login");
                Optional<User> user = userService.loginUser(loginInfoDto);
                System.out.println("post login");
                if(user.isPresent()){
                    request.getSession().setAttribute("user",user.get());
                    return "/WEB-INF/index.jsp";
                }
                request.setAttribute("incorrectLoginOrPassword",true);
                return "/WEB-INF/login.jsp";
            } catch (NoSuchUserException e) {
                request.setAttribute("incorrectLoginOrPassword",true);
                return "/WEB-INF/login.jsp";
            }
        }
        request.setAttribute("incorrectLoginOrPassword",true);
        return "/WEB-INF/login.jsp";
    }
}
