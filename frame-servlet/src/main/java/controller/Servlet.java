package controller;


import controller.comand.factory.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("i in");

        String path = request.getRequestURI().replaceFirst(".*/delivery/", "");
        System.out.println(path + 11);
        String page = new ActionFactory().defineCommand(path).execute(request);
        System.out.println(page + 2);
        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", "/delivery/"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}