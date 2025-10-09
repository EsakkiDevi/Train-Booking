
package model; 
public class Passenger 
{ 
	private int passengerId; 
	private int bookingId; 
	private String name; 
	private int age; 
	private String gender; 
	private double fare; 
	public int getPassengerId() 
	{ 
		return passengerId; 
	} 
	public void setPassengerId(int passengerId) 
	{ 
		this.passengerId = passengerId; 
	} 
	public int getBookingId() 
	{ 
		return bookingId; 
		} 
	public void setBookingId(int bookingId) 
	{ 
		this.bookingId = bookingId; 
	} 
	public String getName() 
	{ 
		return name; 
		} 
	public void setName(String name) 
	{ 
		this.name = name; 
		} 
	public int getAge() 
	{ 
		return age; 
		} 
	public void setAge(int age) 
	{ 
		this.age = age; 
		} 
	public String getGender() 
	{ 
		return gender; 
		} 
	public void setGender(String gender) 
	{ 
		this.gender = gender; 
		} 
	public double getFare() 
	{ 
		return fare; 
		} 
	public void setFare(double fare) 
	{ 
		this.fare = fare; 
		} 
	}