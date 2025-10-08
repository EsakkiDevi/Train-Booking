package dao;

import java.sql.*;
import java.util.*;
import model.Station;
import db.database;

public class Stationsdao {
    public List<Station> getAllStations() {
        List<Station> list = new ArrayList<>();
        String sql = "SELECT * FROM station";

        try (Connection con = database.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                list.add(new Station(
                        rs.getString("stncode"),
                        rs.getString("stnname"),
                        rs.getString("stncity")
                ));
            }
        } catch(Exception e) { e.printStackTrace(); }
        return list;
    }
}
