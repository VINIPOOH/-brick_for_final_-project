package controller.comand.action.impl;

import controller.comand.action.ActionCommand;

import javax.servlet.http.HttpServletRequest;

import static controller.constants.PageConstance.REDIRECT_ON_HOME;

public class LogOut implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return REDIRECT_ON_HOME;
    }
}
