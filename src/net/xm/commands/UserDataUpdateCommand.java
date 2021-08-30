package commands;

import connection.Connector;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UserDataUpdateCommand {
    public String update(HttpServletRequest request) {
        int id = 19; //NEED TO DELETE
        Connector regConnector = new Connector();

        Logger logger = Logger.getRootLogger();

        String page = null;
        request.getSession().getId();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");

        {
            regConnector.updateQuery(name, surname, email, phone, city, id);
            logger.info("Updated '" + name + " " + surname + " " + email + " " + phone + " " + city);
            page = "/view/userPage.jsp";
        }
        return page;
    }
}
