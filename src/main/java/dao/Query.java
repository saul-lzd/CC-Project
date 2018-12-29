package dao;


import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author saulopez
 * @date 28th December, 2018
 */
public class Query extends JDBC {

    private static Statement statement;
    private static ResultSet result;

    public static User findUserByName(String name) {
        User user = null;
        try {
            String query = "SELECT * FROM citycorp.user WHERE NAME = \'" + name + "\'";
            
            System.out.println("execute " + query);

            statement = getConnection().createStatement();
            result = statement.executeQuery(query);

            
            while (result.next()) {
                user = new User();
                user.setUserId(Integer.parseInt(result.getString("user_id")));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
            }

        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
        }
        
        return user;
    }

    
    
}
