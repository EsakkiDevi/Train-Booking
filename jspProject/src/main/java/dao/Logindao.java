package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Login;
import db.database; 

public class Logindao {

    public boolean validate(Login login) {
    	System.out.println("VAnthachuuuu");
        boolean status = false;
        try {
            Connection con = database.getConnection(); 
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login.getUserName()); // email
            ps.setString(2, login.getPassword());

            System.out.println("Checking login for Email: " + login.getUserName());
            System.out.println("Password: " + login.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
                System.out.println("✅ Login success for " + login.getUserName());
            } else {
                System.out.println("❌ Login failed - no matching record found.");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
