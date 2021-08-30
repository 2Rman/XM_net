package commands;

import connection.Connector;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegistrationCommand {

    public String register(HttpServletRequest request){
        Connector regConnector = new Connector();
        HttpSession session = request.getSession();

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

        logger.info(session.getAttribute(login));

        return page;
    }
}
