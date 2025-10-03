package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Login;
import db.database; 

public class Logindao {

    public boolean validate(Login login) {
        boolean status = false;
        try {
            Connection con = database.getConnection(); 

            String sql = "SELECT * FROM users WHERE fullname=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login.getUserName());
            ps.setString(2, login.getPassword());

            ResultSet rs = ps.executeQuery();
            status = rs.next(); 

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}