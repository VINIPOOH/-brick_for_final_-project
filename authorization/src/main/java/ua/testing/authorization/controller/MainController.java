package ua.testing.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.testing.authorization.entity.User;
import ua.testing.authorization.service.UserService;

import java.util.List;

@Controller
public class MainController {

    UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }


    @RequestMapping(value = {"/admin/users"}, method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ADMIN')")
    public ModelAndView users() {
        ModelAndView view = new ModelAndView("admin/users");
        List<User> usersList = userService.getAllUsers();
        view.addObject(usersList);
        return view;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", true);

        return "index";
    }


}
