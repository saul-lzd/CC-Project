package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author saulopez
 * @date 28th December, 2018
 */
public class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/citycorp";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection connection = null;
        
    
    /**
     *
     * @return a connection to the DB
     */
    public static Connection getConnection() throws SQLException {  
        
        if (connection == null) {
            connect();
        }
        return connection;
    }
    
    
    /**
     * This method initialize the connection to the DB
     */
    private static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
