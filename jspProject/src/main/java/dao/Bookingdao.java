package dao;

import java.sql.*;
import model.Booking;
import db.database;

public class Bookingdao {

    public boolean saveBooking(Booking b) {
        String sql = "INSERT INTO bookings(username, train_no, train_name, source, destination, departure_time, arrival_time, seats_booked, quota, total_fare) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, b.getUsername());
            ps.setInt(2, b.getTrainNo());
            ps.setString(3, b.getTrainName());
            ps.setString(4, b.getSource());
            ps.setString(5, b.getDestination());
            ps.setString(6, b.getDepartureTime());
            ps.setString(7, b.getArrivalTime());
            ps.setInt(8, b.getSeatsBooked());
            ps.setString(9, b.getQuota());
            ps.setDouble(10, b.getTotalFare());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
