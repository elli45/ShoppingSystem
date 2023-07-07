package com.example.shoppingsystem;

import java.sql.*;

public class MyDatabase {
    private Connection connection = null;

    public Connection openDatabase(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/database.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean closeConnection(){
        if (connection != null) {
            try {
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public void getAllUsers() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * From Users");
            while (resultset.next()) {
                System.out.println(resultset.getString("username"));
                System.out.println(resultset.getString("password"));
            }
        }else {
            System.out.println("Open Database");
        }

    }


}
