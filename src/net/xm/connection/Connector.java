package connection;

import com.mysql.cj.util.DnsSrv;
import org.apache.log4j.Logger;

import java.sql.*;

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
            statement.setString(1,login);
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
            preparedStatement.setString(1, surname);
            preparedStatement.setString(1, email);
            preparedStatement.setString(1, phone);
            preparedStatement.setString(1, city);
            preparedStatement.setInt(1, id);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}
