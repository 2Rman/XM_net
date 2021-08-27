package commands;

import connection.Connector;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

public class Registration {

    public String register(HttpServletRequest request){
        Connector regConnector = new Connector();

        Logger logger = Logger.getRootLogger();

        String page = null;

        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        String passwordRep = request.getParameter("passR");


        if (!password.equals(passwordRep)) {
            page = "/view/registrationPassErr.jsp";
        } else {
            regConnector.regQuery(login,password);
            logger.info("New account '" + login + "' created");
            page = "/view/userDataPage.jsp";
        }
        return page;
    }
}
