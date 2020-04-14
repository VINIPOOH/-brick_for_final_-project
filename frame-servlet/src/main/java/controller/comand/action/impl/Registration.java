package controller.comand.action.impl;

import controller.comand.action.MultipleMethodCommand;
import dto.RegistrationInfoDto;
import dto.maper.RequestDtoMapper;
import dto.validation.Validator;
import exeptions.OccupiedLoginException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

public class Registration extends MultipleMethodCommand {

    private  final RequestDtoMapper<RegistrationInfoDto> registrationDtoMapper;
    private final Validator<RegistrationInfoDto> registrationInfoDtoValidator;
    private final UserService userService;

    public Registration(RequestDtoMapper<RegistrationInfoDto> registrationDtoMapper, Validator<RegistrationInfoDto> registrationInfoDtoValidator, UserService userService) {
        this.registrationDtoMapper = registrationDtoMapper;
        this.registrationInfoDtoValidator = registrationInfoDtoValidator;
        this.userService = userService;
    }

    @Override
    protected String performGet(HttpServletRequest request) {
        return "/WEB-INF/registration.jsp";
    }

    @Override
    protected String performPost(HttpServletRequest request) {
        RegistrationInfoDto registrationInfoDto = registrationDtoMapper.mapToDto(request);

        if(!registrationInfoDtoValidator.validate(registrationInfoDto)){
            request.setAttribute("inputHasErrors",true);
            return "/WEB-INF/registration.jsp";
        }
        try {
            userService.addNewUserToDB(registrationInfoDto);
            return "redirect:/login";
        } catch (OccupiedLoginException e) {
            request.setAttribute("inputLoginAlreadyTaken",true);
        }
        return "/WEB-INF/registration.jsp";
    }
}
