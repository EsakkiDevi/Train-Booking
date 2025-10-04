package dao;

import java.sql.*;
import java.util.*;
import model.Train;
import db.database; // Your DB connection class

public class Traindao {

    public List<Train> getTrains(String from, String to) {
        List<Train> trains = new ArrayList<>();
        String sql = "SELECT \"Train No\", \"Train Name\", \"Departure Time\", \"Arrival time\", Distance " +
                     "FROM mytable " +
                     "WHERE \"Source Station\" = ? AND \"Destination Station\" = ? " +
                     "GROUP BY \"Train No\", \"Train Name\", \"Departure Time\", \"Arrival time\", Distance";

        try (Connection con = database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, from);
            ps.setString(2, to);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trains.add(new Train(
                        rs.getString("Train No"),
                        rs.getString("Train Name"),
                        rs.getString("Departure Time"),
                        rs.getString("Arrival time"),
                        rs.getString("Distance"),
                        100 // default seats
                ));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trains;
    }
}
