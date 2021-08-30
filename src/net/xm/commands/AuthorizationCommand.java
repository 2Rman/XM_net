package commands;

import connection.Connector;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AuthorizationCommand {
    ArrayList <String> accountData = new ArrayList<>();

    public String authorize(HttpServletRequest request) {
        Connector connector = new Connector();
        GetAccountAction accountGetter = new GetAccountAction();

        Logger logger = Logger.getRootLogger();
        logger.info("auth: Authorization initiated");

        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        logger.info("auth: parameters got: " + login + " " + pass);

        String dbPass = connector.checkLoginQuery(login);

        if (dbPass.equals(pass)){
            accountData = accountGetter.getAccountData(login);
            session.setAttribute("name", accountData.get(0));
            session.setAttribute("surname", accountData.get(1));
            session.setAttribute("email", accountData.get(2));
            session.setAttribute("phone", accountData.get(3));
            session.setAttribute("city", accountData.get(4));
            return "/view/userPage.jsp";
        } else return "/view/authorizationFail.jsp";
    }
}
