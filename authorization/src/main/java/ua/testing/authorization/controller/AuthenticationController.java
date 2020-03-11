package ua.testing.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.testing.authorization.controller.validation.RegistrationDtoValidator;
import ua.testing.authorization.controller.validation.RegularValidator;
import ua.testing.authorization.controller.validation.Validator;
import ua.testing.authorization.dto.RegistrationInfoDto;
import ua.testing.authorization.service.AuthenticationService;
import ua.testing.authorization.service.UserService;

import java.util.Locale;
import java.util.ResourceBundle;

@Controller
public class AuthenticationController {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final Validator validator = new RegistrationDtoValidator(ResourceBundle.getBundle(
            "regular_templates"
            , new Locale("en")));;

    @Autowired
    public AuthenticationController(PasswordEncoder passwordEncoder, AuthenticationService authenticationService, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
        this.userService = userService;
        //this.validator = validator;
    }

    @RequestMapping(value = {"/login/error"}, method = RequestMethod.GET)
    public ModelAndView loginError() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView registrationTry() {
        return new ModelAndView("registration");
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public ModelAndView registrationTry(RegistrationInfoDto registrationInfoDto) {
        RegularValidator regularValidator = new RegularValidator(LocaleContextHolder.getLocale());
        if (validator.isValid(registrationInfoDto)) {
            System.out.println(1);
            registrationInfoDto.setPassword
                    (passwordEncoder.encode(registrationInfoDto.getPassword()));
            userService.addNewUserToDB(
                    authenticationService.convertRegistrationDotToSimpleUserReadyForAddToDB
                            (registrationInfoDto)
            );
            return new ModelAndView("login");
        } else {
            return new ModelAndView("registration");
        }
    }
}
