package dao;

import db.database;
import model.Register;
import java.sql.*;
public class Profiledao {

    // Fetch user by email
    public static Register getUserByEmail(String email) {
        Register user = null;
        try (Connection con = database.getConnection()) {
            String sql = "SELECT fullname, email, phone, password FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new Register();
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Update user profile
    public static boolean updateUserProfile(Register user) {
        boolean success = false;
        try (Connection con = database.getConnection()) {
            String sql = "UPDATE users SET fullname=?, phone=?, password=? WHERE email=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());

            int i = ps.executeUpdate();
            success = i > 0;
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
