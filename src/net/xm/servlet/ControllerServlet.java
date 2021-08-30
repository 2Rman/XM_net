package servlet;

import commands.Factory;
import connection.Connector;
import org.apache.log4j.Logger;
import commands.ConstantCommands;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet
public class ControllerServlet extends HttpServlet {

    private static Logger logger = Logger.getRootLogger();

    Connector connector = new Connector();
    Factory factory = new Factory();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        requestDistributor(request, response);
    }

    public void requestDistributor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info(request.getParameter("command"));
        String redirectPage = factory.getCommand(request);
        if (redirectPage == null) {
             response.sendRedirect(request.getContextPath() + "/error_404");
        } else response.sendRedirect(request.getContextPath() + redirectPage);
    }
}
