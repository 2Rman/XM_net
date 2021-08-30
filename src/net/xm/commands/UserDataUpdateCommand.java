package commands;

import connection.Connector;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserDataUpdateCommand {
    public String update(HttpServletRequest request) {
        Connector regConnector = new Connector();

        Logger logger = Logger.getRootLogger();

        String page = null;

        HttpSession session = request.getSession();

        logger.info("UserDataUpdateCommand Started");
        String logAttr = (String) session.getAttribute("login");

        int id = regConnector.doQuery(logAttr);

        logger.info("From UserDataUpdate. Id - " + id);
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");

        regConnector.updateQuery(name, surname, email, phone, city, id);
        logger.info("Updated " + id + " " + name + " " + surname + " " + email + " " + phone + " " + city);
        page = "/view/userPage.jsp";

        return page;
    }
}
