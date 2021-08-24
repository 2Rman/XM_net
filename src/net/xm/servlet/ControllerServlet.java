package servlet;

import connection.Connector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class ControllerServlet extends HttpServlet {

    Connector connector = new Connector();

    protected void doGet(HttpServletResponse response, HttpServletRequest request) {

    }

    protected void doPost(HttpServletResponse response, HttpServletRequest request) {
//        реализовать получение запроса
        String action = request.getParameter("command");
        System.out.println(request.getContextPath());
        if (request != null) {
            System.out.println(request);

        }
        if (action == "DO") {
            connector.doQuery();
            log("трымай");
        } else log("none");
    }
}
