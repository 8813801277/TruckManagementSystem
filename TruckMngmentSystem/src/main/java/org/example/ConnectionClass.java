package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    //public static final String Load_driver = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/truckmgt";
    public static final String Password = "Papa@1234";
    public static final String Username = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL  , Username , Password);
    }

}
