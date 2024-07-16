package com.amit.sholoklogistics.dao;

import com.amit.sholoklogistics.database.Database;
import com.amit.sholoklogistics.model.RequestModel;
import java.sql.*;
import java.util.ArrayList;

/**
 * DAO class for RequestModel
 */
public class RequestDao {
    public static final String TABLENAME = "requests";

    public String insert(RequestModel model) {
        Connection con = null;
        String message = null;
        CallableStatement cs = null;
        String sql = "insert into " + TABLENAME + " (departure_city, delivery_city, weight, dimensions, name, email, phone, message) values (?,?,?,?,?,?,?,?)";
        try {
            con = Database.connectDb();
            cs = con.prepareCall(sql);
            cs.setString(1, model.getDepartureCity());
            cs.setString(2, model.getDeliveryCity());
            cs.setDouble(3, model.getWeight());
            cs.setString(4, model.getDimensions());
            cs.setString(5, model.getName());
            cs.setString(6, model.getEmail());
            cs.setString(7, model.getPhone());
            cs.setString(8, model.getMessage());

            int row = cs.executeUpdate();

            if (row >= 1) {
                message = "Request added successfully";
            }
        } catch (SQLException ex) {
            message = "Unable to add because of: " + ex.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (cs != null) {
                    cs.close();
                }
            } catch (SQLException e) {
                // Log the exception
            }
        }
        return message;
    }

    public ArrayList<RequestModel> findAll() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<RequestModel> requests = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLENAME;

        try {
            con = Database.connectDb();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RequestModel request = new RequestModel();
                request.setDepartureCity(rs.getString("departure_city"));
                request.setDeliveryCity(rs.getString("delivery_city"));
                request.setWeight(rs.getDouble("weight"));
                request.setDimensions(rs.getString("dimensions"));
                request.setName(rs.getString("name"));
                request.setEmail(rs.getString("email"));
                request.setPhone(rs.getString("phone"));
                request.setMessage(rs.getString("message"));
                requests.add(request);
            }
        } catch (SQLException ex) {
            // Log the exception
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Log the exception
            }
        }
        return requests;
    }

 

    public String deletePost(String id) {
Connection con = null;
        CallableStatement cs = null;
        String message = null;
        String sql = "DELETE FROM " + TABLENAME + " WHERE id = ?"; // Assuming 'id' is the primary key

        try {
            con = Database.connectDb();
            cs = con.prepareCall(sql);
            cs.setString(1, id);

            int row = cs.executeUpdate();

            if (row >= 1) {
                message = "Request deleted successfully";
            } else {
                message = "Request not found";
            }
        } catch (SQLException ex) {
            message = "Unable to delete because of: " + ex.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (cs != null) {
                    cs.close();
                }
            } catch (SQLException e) {
                // Log the exception
            }
        }
        return message;    }
}
