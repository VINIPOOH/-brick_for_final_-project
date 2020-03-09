package ua.testing.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.testing.authorization.controller.validation.PasswordValidator;
import ua.testing.authorization.controller.validation.RegularValidator;
import ua.testing.authorization.dto.RegistrationInfoDto;
import ua.testing.authorization.service.AuthenticationService;
import ua.testing.authorization.service.UserService;

@Controller
public class AuthenticationController {

    private final  PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;
    private final UserService userService;
@Autowired
    public AuthenticationController(PasswordEncoder passwordEncoder, AuthenticationService authenticationService, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @Autowired


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView registrationTry() {
        ModelAndView view = new ModelAndView("registration");
        return view;
    }
    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public ModelAndView registrationTry(RegistrationInfoDto registrationInfoDto) {
        RegularValidator regularValidator =new RegularValidator(LocaleContextHolder.getLocale());
        if (regularValidator.isEmailValid(registrationInfoDto.getUsername())
                && registrationInfoDto.getPassword().equals(registrationInfoDto.getPasswordRepeat())){
            registrationInfoDto.setPassword
                    (passwordEncoder.encode(registrationInfoDto.getPassword()));
            userService.addNewUserToDB(
                    authenticationService.convertRegistrationDotToSimpleUserReadyForAddToDB
                            (registrationInfoDto)
            );
            ModelAndView view = new ModelAndView("login");
            return view;
        }else {
            ModelAndView view = new ModelAndView("registration");
            return view;
        }
    }
}
