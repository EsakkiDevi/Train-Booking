package dao;

import java.sql.*;
import model.Passengers;
import db.database;

public class Passengersdao {

    public boolean addPassenger(Passengers passenger) {
        String sql = "INSERT INTO passengers(booking_id, name, age, gender) VALUES(?,?,?,?)";
        try (Connection con = database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, passenger.getBookingId());
            ps.setString(2, passenger.getName());
            ps.setInt(3, passenger.getAge());
            ps.setString(4, passenger.getGender());

            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
