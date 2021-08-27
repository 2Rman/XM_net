package connection;

import org.apache.log4j.Logger;

import java.sql.*;

public class Connector {

    Logger logger = Logger.getRootLogger();

    Connection connection = null;
    Statement statement = null;

    String url = "jdbc:mysql://localhost:3306/xm_start";
    private String username = "admin";
    private String password = "Ghjuhfvvf795!";

    public ResultSet doQuery() {
        ResultSet result = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM account WHERE id = 1;");

            while (result.next()) {
                logger.info(result.getString("login") + " " + result.getString("password"));
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public void regQuery(String login, String pass) {

        ResultSet result = null;
        String id = null;

        logger.info("Registration query to DB");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            statement.executeUpdate("INSERT account (login, password) " +
                    "values ('" + login + "','" + pass + "');");


            result = statement.executeQuery("SELECT id FROM xm_start.account\n" +
                    "WHERE login = '" + login + "';");
            if (result.next()) {
                id = result.getString(1);
            }

            logger.info("new account's id = " + id);

            statement.executeUpdate("INSERT xm_start.user (id) " +
                    "values ('" + id + "');");

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
