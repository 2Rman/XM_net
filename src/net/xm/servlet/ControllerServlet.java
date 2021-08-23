package servlet;

import connection.Connector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet
public class ControllerServlet extends HttpServlet {
    Connector connector = new Connector();
    protected void doGet(HttpServletResponse response, HttpServletRequest request) {

    }

    protected void doPost(HttpServletResponse response, HttpServletRequest request) {
//        реализовать получение запроса

    }
}
