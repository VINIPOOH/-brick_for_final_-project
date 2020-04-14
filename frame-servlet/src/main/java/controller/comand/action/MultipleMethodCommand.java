package controller.comand.action;

import javax.servlet.http.HttpServletRequest;

public abstract class MultipleMethodCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String type = request.getMethod();

        return "GET".equals(type)
                ? performGet(request)
                : performPost(request);
    }

    protected abstract String performGet(HttpServletRequest request);

    protected abstract String performPost(HttpServletRequest request);

}
