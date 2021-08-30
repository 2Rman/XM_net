package connection;

import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;

public class Connector {

    Logger logger = Logger.getRootLogger();

    Connection connection = null;
    PreparedStatement statement = null;

    String url = "jdbc:mysql://localhost:3306/xm_start";
    private String username = "admin";
    private String password = "Ghjuhfvvf795!";

    public int doQuery(String login) {
        ResultSet result = null;
        int id = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connection == null) {
                connection = DriverManager.getConnection(url, username, password);
            }
            String sql = "SELECT id FROM xm_start.account WHERE login = ?;";

            statement = connection.prepareStatement(sql);
            statement.setString(1, login);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void regQuery(String login, String pass) {

        int id = 0;
        ResultSet result = null;

        logger.info("Registration query to DB");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT account (login, password) values (?,?);";
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, pass);
            int rowToInsert = statement.executeUpdate();

            logger.info("DB has been updated. New ");

            id = doQuery(login);

            logger.info("new account's id = " + id);

            String sqlUserTable = "INSERT xm_start.user (id) values (?);";

            logger.info(id);

            statement = connection.prepareStatement(sqlUserTable);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuery(String name, String surname, String email, String phone, String city, int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            String sql = "UPDATE xm_start.user \n" +
                    "SET name = ?,\n" +
                    " surname = ?,\n" +
                    " email = ?, \n" +
                    " phone = ?,\n" +
                    " city = ?\n" +
                    "where id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, city);
            preparedStatement.setInt(6, id);

            int rowsAffected = preparedStatement.executeUpdate();

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkLoginQuery(String login) {
        ResultSet result = null;
        int id = 0;
        String pass = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            logger.info("dbConnect: authorization-query initiated with parameters: " + login);

            String sql = "SELECT * FROM xm_start.account WHERE login = ?"; //PREPARE QUERY

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, login);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                pass = result.getString(3);
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return pass;
    }

    public ArrayList<String> idFromLoginQuery(String login) {

        int id = 0;
        ResultSet result = null;
        ArrayList<String> userData = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            logger.info("dbConnect: authorization-query initiated with parameters: " + login);

            String sqlIdFromLogin = "SELECT id FROM xm_start.account WHERE login = ?"; //PREPARE QUERY

            PreparedStatement preparedStatementId = connection.prepareStatement(sqlIdFromLogin);

            preparedStatementId.setString(1, login);

            result = preparedStatementId.executeQuery();

            if (result.next()) {
                id = result.getInt(1);

            }
            logger.info("dbConnect: ID from login got: " + id);
            logger.info("dbConnect: extracting UserDATA from DB with id " + id);

            String sqlDataFromId = "SELECT * FROM xm_start.user WHERE id = ?;";

            PreparedStatement preparedStatementData = connection.prepareStatement(sqlDataFromId);

            preparedStatementData.setInt(1, id);

            result = preparedStatementData.executeQuery();

            if (result.next()) {
                userData.add(result.getString(2));
                userData.add(result.getString(3));
                userData.add(result.getString(4));
                userData.add(result.getString(5));
                userData.add(result.getString(6));
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return userData;
    }
}
