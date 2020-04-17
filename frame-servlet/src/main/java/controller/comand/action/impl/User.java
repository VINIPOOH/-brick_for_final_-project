package controller.comand.action.impl;

import controller.comand.action.DoubleMethodCommand;

import javax.servlet.http.HttpServletRequest;

public class User extends DoubleMethodCommand {
    @Override
    protected String performGet(HttpServletRequest request) {
        return "WEB-INF/user/u.jsp";
    }

    @Override
    protected String performPost(HttpServletRequest request) {
        return null;
    }
}
