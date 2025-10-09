package dao; 
import java.sql.*; 
import java.util.*; 
import model.Booking; 
import db.database;
public class Bookingdao 
{ 
	public int saveBooking(Booking b) 
	{ 
		int id = 0; 
		try (Connection con = database.getConnection(); 
				PreparedStatement ps = con.prepareStatement( "INSERT INTO bookings(username,train_no,seats_booked,quota,payment_status,booking_time) VALUES(?,?,?,?,?,NOW())", 
						Statement.RETURN_GENERATED_KEYS)) 
		{ 
			ps.setString(1, b.getUsername()); 
			ps.setString(2, b.getTrainNo()); 
			ps.setInt(3, b.getSeatsBooked()); 
			ps.setString(4, b.getQuota()); 
			ps.setString(5, b.getPaymentStatus()); 
			ps.executeUpdate(); 
			ResultSet rs = ps.getGeneratedKeys(); 
			if (rs.next()) 
				id = rs.getInt(1); 
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			} 
		return id; 
		} 
	public List<Booking> getBookingsByUser(String username) 
	{ 
		List<Booking> list = new ArrayList<>(); 
		try (Connection con = database.getConnection(); 
				PreparedStatement ps = con.prepareStatement( "SELECT * FROM bookings WHERE username=? ORDER BY booking_time DESC")) 
		{ 
			ps.setString(1, username); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{ 
				Booking b = new Booking(); 
				b.setBookingId(rs.getInt("booking_id")); 
				b.setUsername(rs.getString("username")); 
				b.setTrainNo(rs.getString("train_no")); 
				b.setSeatsBooked(rs.getInt("seats_booked")); 
				b.setQuota(rs.getString("quota")); 
				b.setPaymentStatus(rs.getString("payment_status")); 
				b.setBookingTime(rs.getTimestamp("booking_time")); 
				list.add(b); 
				} 
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} return list; } }