package dao;

import java.sql.*;
import java.util.*;
import model.Train;
import db.database;

public class Traindao {

    public List<Train> getAllTrains() {
        List<Train> list = new ArrayList<>();
        String sql = "SELECT * FROM train_details";
        try (Connection con = database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Train(
                        rs.getInt("train_no"),
                        rs.getString("name"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getInt("seats_available"),
                        rs.getDouble("fare")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Train> searchTrains(String from, String to) {
        List<Train> list = new ArrayList<>();
        String sql = "SELECT * FROM train_details WHERE source=? AND destination=?";
        try (Connection con = database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, from);
            ps.setString(2, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Train(
                        rs.getInt("train_no"),
                        rs.getString("name"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getInt("seats_available"),
                        rs.getDouble("fare")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean updateSeats(int trainNo, int seatsBooked) throws SQLException {
        String sql = "UPDATE train_details SET seats_available = seats_available - ? WHERE train_no=? AND seats_available >= ?";
        try (Connection con = database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, seatsBooked);
            ps.setInt(2, trainNo);
            ps.setInt(3, seatsBooked);
            return ps.executeUpdate() > 0;
        }
    }
}
