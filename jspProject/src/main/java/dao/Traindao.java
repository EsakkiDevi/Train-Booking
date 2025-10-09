package dao; 
import java.sql.*; 
import java.util.*; 
import model.Train; 
import db.database; 
public class Traindao 
{ // Fetch trains by source and destination 
	public List<Train> getTrains(String source, String destination) 
	{ 
		List<Train> list = new ArrayList<>(); 
		try (Connection con = database.getConnection(); 
				PreparedStatement ps = con.prepareStatement( "SELECT * FROM train_details WHERE source=? AND destination=?")) 
		{ 
			ps.setString(1, source); 
			ps.setString(2, destination); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) 
			{ 
				Train t = new Train(); 
				t.setTrainNo(rs.getString("train_no")); 
				t.setName(rs.getString("name")); 
				t.setDepartureTime(rs.getString("departure_time")); 
				t.setArrivalTime(rs.getString("arrival_time")); 
				t.setDuration(rs.getString("duration")); 
				t.setSeatsAvailable(rs.getInt("seats_available")); 
				t.setSource(rs.getString("source")); 
				t.setDestination(rs.getString("destination")); 
				t.setFare(rs.getDouble("fare")); list.add(t); 
				} 
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			} 
		return list; 
		} // Get current available seats for a train 
	public int getAvailableSeats(int trainNo) 
	{ 
		int seats = 0;
		try (Connection con = database.getConnection(); 
				PreparedStatement ps = con.prepareStatement( "SELECT seats_available FROM train_details WHERE train_no=?")) 
		{ 
			ps.setInt(1, trainNo); 
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) 
			{ 
				seats = rs.getInt("seats_available"); 
				} 
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			} 
		return seats; 
		} // Update seats only if enough are available 
	public boolean updateSeats(String trainNo, int seatsBooked) 
	{ 
		boolean updated = false; 
		try (Connection con = database.getConnection(); 
				PreparedStatement ps = con.prepareStatement( "UPDATE train_details SET seats_available = seats_available - ? WHERE train_no=? AND seats_available >= ?")) 
		{ 
			ps.setInt(1, seatsBooked); 
			ps.setString(2, trainNo); 
			ps.setInt(3, seatsBooked); 
			int rows = ps.executeUpdate(); 
			if (rows > 0) 
			{ 
				updated = true; 
				System.out.println("Seats updated successfully for train " + trainNo); } 
			else 
			{ 
				System.out.println("Seat update failed: Not enough seats available or invalid train number."); 
				} 
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			} 
		return updated; 
		} 
	}
