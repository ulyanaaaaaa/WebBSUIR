package Connection;

import java.util.*;
import java.sql.*;

public class JDBC {

    public static Connection connection = null;
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
