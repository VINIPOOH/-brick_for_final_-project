package controller.comand.action;

import javax.servlet.http.HttpServletRequest;

public abstract class DoubleMethodCommand implements ActionCommand {
    
    private final String STANDARD_COMMAND = "GET";
    @Override
    public String execute(HttpServletRequest request) {
        String type = request.getMethod();

        return STANDARD_COMMAND.equals(type)
                ? performGet(request)
                : performPost(request);
    }

    protected abstract String performGet(HttpServletRequest request);

    protected abstract String performPost(HttpServletRequest request);

}
