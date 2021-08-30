package commands;

import javax.servlet.http.HttpServletRequest;


public class Factory {

    public String getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        String page = null;

        CommandsEnum commandEnum = CommandsEnum.valueOf(action.toUpperCase());

        switch (commandEnum) {
            case REGISTER: {
                RegistrationCommand registration = new RegistrationCommand();
                page = registration.register(request);
                break;
            }
            case AUTHORIZE: {
                AuthorizationCommand authorization = new AuthorizationCommand();
                page = authorization.authorize(request);
                break;
            }
            case USERDATAUPDATE: {
                UserDataUpdateCommand userDataUpdate = new UserDataUpdateCommand();
                page = userDataUpdate.update(request);
                break;
            }
            case LOGOUT: {
                LogoutCommand logoutCommand = new LogoutCommand();
                page = logoutCommand.logout(request);
            }
        }
        return page;
    }
}

