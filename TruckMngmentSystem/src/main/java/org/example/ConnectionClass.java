package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    //public static final String Load_driver = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "enter your db url here";
    public static final String Password = "enter your password of db";
    public static final String Username = "enter your username of db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL  , Username , Password);
    }

}
