package dao;

import model.Register;
import db.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Registerdao {
	
	 public boolean isUserExist(String email, String phone) {
	        String sql = "SELECT id FROM users WHERE email=? OR phone=?";
	        try (Connection conn = database.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setString(1, email);
	            ps.setString(2, phone);

	            ResultSet rs = ps.executeQuery();
	            return rs.next(); // true if user exists

	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

    public boolean registerUser(Register user) {
        String sql = "INSERT INTO users (fullname, email, phone, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getPassword()); // ideally hashed
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
