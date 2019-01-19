/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author saulopez
 */
public class UserDAO extends Derby {
    
    /**
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
    public static User findById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from users where user_id = " + id);
        
        User user = null;
        while (result.next()) {
            user = new User();
            user.setUserId(Integer.parseInt(result.getString("user_id")));
            user.setName(result.getString("name"));
            user.setPassword(result.getString("password"));
        }
        
        return user;
    }
    
    /**
     * 
     * @throws SQLException 
     */
    public void findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            System.out.println("(" + rs.getInt("user_id") + ")" + rs.getString("name") + " - " + rs.getString("password"));
        }
    }
    
    /**
     * 
     * @throws SQLException 
     */
    public static void insertDefaults() throws SQLException {
        Statement statement = connection.createStatement();
        String query;

        for (int i = 1; i < 6; i++) {
            query = "insert into users values (#, 'user_#', 'password#')";
            query = query.replace("#", String.valueOf(i));
            statement.executeUpdate(query);
        }
    }
    
}
