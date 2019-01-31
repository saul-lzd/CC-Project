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
import java.util.ArrayList;
import java.util.List;

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
    public static List<User> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM users");
        List<User> usersList = new ArrayList();
        
        User user = null;
        while (result.next()) {
            user = new User();
            user.setUserId(Integer.parseInt(result.getString("user_id")));
            user.setName(result.getString("name"));
            user.setPassword(result.getString("password"));
            usersList.add(user);
        }
        
//        while (rs.next()) {
//            System.out.println("(" + rs.getInt("user_id") + ")" + rs.getString("name") + " - " + rs.getString("password"));
//        }
        return usersList;
    }

    
    /**
     *
     * @param user
     * @throws SQLException
     */
    public static void insert(User user) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "insert into users values (@userId, '@username', '@password')";
            System.out.println("INSERT: " + query);
            query = query.replace("@userId", String.valueOf(user.getUserId()));
            query = query.replace("@username", user.getName());
            query = query.replace("@password", user.getPassword());

            statement.executeUpdate(query);
        }
    }
    
    
    public static void update(String userId, User user) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "update users set user_id = @userId, name = '@username', password = '@password' where user_id =" + userId;
            query = query.replace("@userId", String.valueOf(user.getUserId()));
            query = query.replace("@username", user.getName());
            query = query.replace("@password", user.getPassword());

            statement.executeUpdate(query);
        }
    }

    /**
     *
     * @param userId
     * @throws SQLException
     */
    public static void deleteById(String userId) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "delete from users where user_id = " + userId;
            statement.execute(query);
        }
    }

    /**
     *
     * @throws SQLException
     */
    public static void insertDefaults() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query;

            for (int i = 1; i < 6; i++) {
                query = "insert into users values (#, 'user_#', 'password#')";
                query = query.replace("#", String.valueOf(i));
                statement.executeUpdate(query);
            }
        }
    }

}
