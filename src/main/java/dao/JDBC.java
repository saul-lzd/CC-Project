package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author saulopez
 * @date 28th December, 2018
 */
public class JDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/citycorp";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection connection = null;

    
    /**
     * This method initialize the connection to the DB
     */
    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Unable to connect to DB");
            e.printStackTrace();
        }

    }

    /**
     *
     * @return a connection to the DB
     */
    public static Connection getConnection() {        
        return connection;
    }

}
