/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amit.sholoklogistics.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Amit
 */
public class Database {
    
    
    private static final String DATABASE = "sholok";
    private static final String DBURL = "jdbc:mysql://localhost/" + DATABASE;
    private static final String DBUSER = "root";
    private static final String DBPASS = "12345";
    public static Connection connectDb() {
        Connection con = null;
        try {
            //Driver Registration
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
           System.out.println("DB Connention Successfull");
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
       Database.connectDb();
    }
    
}
