package servlet;

import connection.Connector;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class ControllerServlet extends HttpServlet {

    private static Logger logger = Logger.getRootLogger();

    Connector connector = new Connector();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("command").equals("do")) {
            logger.info("Command finally got, so the query should be done");
            connector.doQuery();
        }
    }
}
