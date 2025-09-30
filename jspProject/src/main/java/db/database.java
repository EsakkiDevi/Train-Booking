package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
	 private static final String URL = "jdbc:postgresql://localhost:5432/train_booking";
	    private static final String USER = "postgres";
	    private static final String PASSWORD = "postgres@123";

	    public static Connection getConnection() {
	        Connection conn = null;
	        try {
	            Class.forName("org.postgresql.Driver");
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            System.out.println("PostgreSQL JDBC Driver not found!");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Connection Failed! Check username/password and DB server.");
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("Unknown error occurred while connecting to DB.");
	            e.printStackTrace();
	        }
	        return conn;

}
}
