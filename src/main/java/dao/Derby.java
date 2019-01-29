/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author saulopez
 */
public class Derby {

    private static final String QUERY_TABLE_USERS = "create table users (user_id INT primary key, name VARCHAR (45), password VARCHAR(100))";
    private static final String QUERY_TABLE_PROJECT = "create table project (project_id INT primary key, name VARCHAR (45), description VARCHAR(200), created_by INT)";
    private static final String QUERY_TABLE_REQUIREMENT = "create table requirement (requirement_id INT primary key, name VARCHAR (45), description VARCHAR(200), created_by INT, type VARCHAR(45), content VARCHAR(250))";

    protected static Connection connection;
    //private static String dbUrl = "jdbc:derby:." + File.separator + "database;create=true";
    private static String dbUrl = "jdbc:derby:database" + File.separator + "db;create=true";

    public static void init() throws SQLException {
        connect();
        createTables();
    }

    /**
     *
     * @throws SQLException
     */
    private static void connect() throws SQLException {
        connection = DriverManager.getConnection(dbUrl);
    }

    /**
     *
     * @throws SQLException
     */
    private static void createTables() throws SQLException {
        Statement statement;

        try {
            // Open Connection
            statement = connection.createStatement();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }

        try {
            // create tables
            statement.executeUpdate(QUERY_TABLE_USERS);
            statement.executeUpdate(QUERY_TABLE_PROJECT);
            statement.executeUpdate(QUERY_TABLE_REQUIREMENT);
        } catch (SQLException ex) {
            System.out.println("Tables already exists.");
        }

        try {
            // Insert default users
            UserDAO.insertDefaults();
        } catch (SQLException ex) {
            System.out.println("Default users already exists.");
        }
    }

}
