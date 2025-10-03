package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Traindao {
    private Connection con;

    public Traindao(Connection con) {
        this.con = con;
    }

    // Reduce seats after booking
    public void reduceSeats(String trainNo, int count) throws SQLException {
        String sql = "UPDATE trains SET available_seats = available_seats - ? WHERE train_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, count);
        ps.setString(2, trainNo);
        ps.executeUpdate();
        ps.close();
    }
}
