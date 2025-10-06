package dao;

import java.sql.*;
import java.util.*;
import model.Train;

public class Traindao {
    private Connection con;
    public Traindao(Connection con){ this.con = con; }

    public List<Train> getAllTrains(){
        List<Train> list = new ArrayList<>();
        String sql = "SELECT * FROM train_details";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Train(
                    rs.getString("train_no"),
                    rs.getString("name"),
                    rs.getString("departure_time"),
                    rs.getString("arrival_time"),
                    rs.getString("duration"),
                    rs.getInt("seats_available"),
                    rs.getString("source"),
                    rs.getString("destination")
                ));
            }
        } catch(Exception e){ e.printStackTrace(); }
        return list;
    }

    public List<Train> getTrainsBySourceDest(String source, String dest){
        List<Train> list = new ArrayList<>();
        String sql = "SELECT * FROM train_details WHERE source=? AND destination=?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, source);
            ps.setString(2, dest);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    list.add(new Train(
                        rs.getString("train_no"),
                        rs.getString("name"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getString("duration"),
                        rs.getInt("seats_available"),
                        rs.getString("source"),
                        rs.getString("destination")
                    ));
                }
            }
        } catch(Exception e){ e.printStackTrace(); }
        return list;
    }

    public List<Train> searchTrains(String source, String dest){
        return getTrainsBySourceDest(source, dest);
    }

    public boolean updateSeats(String trainNo, int seatsBooked) throws SQLException {
        String sql = "UPDATE train_details SET seats_available = seats_available - ? WHERE train_no=? AND seats_available >= ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, seatsBooked);
            ps.setString(2, trainNo);
            ps.setInt(3, seatsBooked);
            return ps.executeUpdate() > 0;
        }
    }
}
