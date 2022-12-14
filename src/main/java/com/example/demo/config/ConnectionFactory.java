package com.example.demo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{

    private static final String DB_URL = "jdbc:postgresql://localhost:5431/products";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    public static Connection getConnection() throws SQLException {


        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;

    }

}
