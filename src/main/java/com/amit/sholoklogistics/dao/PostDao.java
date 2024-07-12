/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amit.sholoklogistics.dao;

import com.amit.sholoklogistics.database.Database;
import com.amit.sholoklogistics.model.PostModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Amit
 */
public class PostDao {
          public static final String TABLENAME = "post";


    public String insert(PostModel model) {Connection con = null;
        String message = null;
        CallableStatement cs = null;
        String sql = "insert into " + TABLENAME + " (name, number, subject, message) values (?,?,?,?)";
        try {
            con = Database.connectDb();
            cs = con.prepareCall(sql);
            cs.setString(1, model.getName());
            cs.setString(2, model.getNumber());
            cs.setString(3, model.getSubject());
            cs.setString(4, model.getMessage());

            int row = cs.executeUpdate();

            if (row >= 1) {
                message = "Post Added Successfull";
            }
        } catch (SQLException ex) {
            message = "unable to add because of : " + ex.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                con = null;

                if (cs != null) {
                    cs.close();
                }
            } catch (SQLException e) {
            }
        }
        return message;
    }

    public ArrayList<PostModel> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String deletePost(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
