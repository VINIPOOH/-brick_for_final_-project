package controller.comand.action.impl;

import controller.comand.action.MultipleMethodCommand;
import service.LocalityService;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static controller.constants.PageConstance.COUNTER_PATH;

public class Counter extends MultipleMethodCommand {

    private final LocalityService localityService;

    public Counter(LocalityService localityService) {
        this.localityService = localityService;
    }

    @Override
    protected String performGet(HttpServletRequest request) {
        Object o =localityService.getLocaliseLocalities();
        request.setAttribute("localityList",o);
        return COUNTER_PATH;
    }

    @Override
    protected String performPost(HttpServletRequest request) {
        return null;
    }
}
