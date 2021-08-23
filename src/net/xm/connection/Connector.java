package connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    java.sql.Connection connection = null;
    Statement statement = null;

    String url = "jdbc:mysql://localhost:3306/xm_start";
    private String username = "admin";
    private String password = "Ghjuhfvvf795!";

    public ResultSet doQuery() {
        ResultSet result = null;

        try {
            Class.forName("com.mysql.cj.jdbc,Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM account WHERE id = 1;");

            while (result.next()) {
                System.out.println(result.getString("login") + " " + result.getString("password"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
