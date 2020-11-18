package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "springstudent";
        String pass = "springstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
