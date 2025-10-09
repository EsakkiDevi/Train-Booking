package dao; 
import java.sql.*; 
import java.util.*; 
import db.database;
import model.Passenger; 
public class Passengerdao 
{ 
	public void savePassengers(List<Passenger> passengers, int bookingId) 
	{ 
		try (Connection con = database.getConnection(); 
				PreparedStatement ps = con.prepareStatement( "INSERT INTO passengers(booking_id, name, age, gender, fare) VALUES(?,?,?,?,?)")) 
		{ 
			for (Passenger p : passengers) 
			{ 
				ps.setInt(1, bookingId); 
				ps.setString(2, p.getName()); 
				ps.setInt(3, p.getAge()); 
				ps.setString(4, p.getGender()); 
				ps.setDouble(5, p.getFare()); 
				ps.addBatch(); 
				} 
			ps.executeBatch(); 
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			} 
		} 
	public List<Passenger> getPassengersByBookingId(int bookingId) 
	{ 
		List<Passenger> list = new ArrayList<>(); 
		try (Connection con = database.getConnection(); 
				PreparedStatement ps = con.prepareStatement( "SELECT passenger_id, booking_id, name, age, gender, fare FROM passengers WHERE booking_id=?")) 
		{ 
			ps.setInt(1, bookingId); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) 
			{ 
				Passenger p = new Passenger(); 
				p.setPassengerId(rs.getInt("passenger_id")); 
				p.setBookingId(rs.getInt("booking_id")); 
				p.setName(rs.getString("name")); 
				p.setAge(rs.getInt("age")); 
				p.setGender(rs.getString("gender")); 
				p.setFare(rs.getDouble("fare")); 
				list.add(p); 
				} 
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			} 
		return list; 
		} 
	}