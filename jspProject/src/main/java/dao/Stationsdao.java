package dao;

import java.sql.*;
import java.util.*;
import model.Station;
import db.database;

public class Stationsdao {
    public List<Station> getAllStations() {
        List<Station> list = new ArrayList<>();
        try {
            Connection con = database.getConnection(); // your DB connection class
            String sql = "SELECT stncode, stnname, stncity FROM stationlist";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Station(
                    rs.getString("stncode"),
                    rs.getString("stnname"),
                    rs.getString("stncity")
                ));
            }
            rs.close();
            ps.close();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
