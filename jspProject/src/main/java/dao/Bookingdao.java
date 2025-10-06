package dao;

import java.sql.*;
import model.Booking;

public class Bookingdao {
    private Connection con;
    public Bookingdao(Connection con){ this.con = con; }

    public boolean addBooking(Booking booking){
        String sql = "INSERT INTO bookings(username, train_no, seats_booked, quota, payment_status, booking_time) VALUES(?,?,?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, booking.getUsername());
            ps.setString(2, booking.getTrainNo());
            ps.setInt(3, booking.getSeatsBooked());
            ps.setString(4, booking.getQuota());
            ps.setString(5, booking.getPaymentStatus());
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis())); // Proper timestamp
            return ps.executeUpdate() > 0;
        } catch(Exception e){ e.printStackTrace(); }
        return false;
    }
}
