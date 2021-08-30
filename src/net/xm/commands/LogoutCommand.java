package commands;


import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand {

    public String logout(HttpServletRequest request){

        Logger logger = Logger.getRootLogger();
        String page = "/view/index.jsp";

        logger.info("logout: logout command executed");

        HttpSession session = request.getSession();

        session.removeAttribute("id");
        session.removeAttribute("login");

        logger.info("logout: logout completed. Session parameters: id - " + session.getAttribute("id") +
                " login - " + session.getAttribute("login"));

        return page;
    }
}
