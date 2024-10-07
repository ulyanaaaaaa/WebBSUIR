package JDBC;

import java.util.*;
import java.sql.*;
//import org.apache.*;
public class JDBC
{
    public static Connection connection = null;

    public static void connect() throws SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost/web?useUnicode=true&serverTimezone=UTC";
        connection = DriverManager.getConnection(url, "root", "vadiog1235670Z");
        if (connection == null)
        {
            throw new SQLException();
        }
        else {
            System.out.println("connected");
        }
    }

    public static void close() {
        try {
            if(connection != null) {
                connection.close();
                System.out.println("Closing connection");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
        }
    }

}
