package commands;

import javax.servlet.http.HttpServletRequest;


public class Factory {

    public String getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        String page = null;

        CommandsEnum commandEnum = CommandsEnum.valueOf(action.toUpperCase());

        switch (commandEnum) {
            case REGISTER: {
                Registration registration = new Registration();
                page = registration.register(request);
                break;
            }
            case AUTHORIZATION:
                AuthorizationCommand authorization = new AuthorizationCommand();
                page = authorization.authorize(request);
                break;
        }
        return page;
    }
}
