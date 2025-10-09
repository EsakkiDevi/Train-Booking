package dao; 
import java.sql.*; 
import java.util.*; 
import model.Station; 
import db.database;
public class Stationsdao 
{ 
	public List<Station> getAllStations() 
	{ 
		List<Station> list = new ArrayList<>(); 
		try (Connection con = database.getConnection(); 
		PreparedStatement ps = con.prepareStatement("SELECT * FROM stationlist")) 
		{ 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) 
			{ 
			Station s = new Station(); 
			s.setStncode(rs.getString("stncode")); 
			s.setStnname(rs.getString("stnname")); 
			s.setStncity(rs.getString("stncity")); 
			list.add(s); 
			}
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	return list; 
	} 
}