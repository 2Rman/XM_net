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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
