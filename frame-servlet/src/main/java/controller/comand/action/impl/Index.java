package controller.comand.action.impl;

import controller.comand.action.MultipleMethodCommand;

import javax.servlet.http.HttpServletRequest;

public class Index extends MultipleMethodCommand {
    @Override
    protected String performGet(HttpServletRequest request) {
        return null;
    }

    @Override
    protected String performPost(HttpServletRequest request) {
        return null;
    }
}
