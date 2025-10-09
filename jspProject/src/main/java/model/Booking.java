package model; 
import java.sql.Timestamp; 
public class Booking 
{ 
	private int bookingId; 
	private String username; 
	private String trainNo; 
	private int seatsBooked; 
	private String quota; 
	private String paymentStatus; 
	private Timestamp bookingTime; 
	public int getBookingId() 
	{ 
		return bookingId; 
	} 
	public void setBookingId(int bookingId) 
	{ 
		this.bookingId = bookingId; 
	} 
	public String getUsername() 
	{ 
		return username; 
	} 
	public void setUsername(String username) 
	{ 
		this.username = username; 
	} 
	public String getTrainNo() 
	{ 
		return trainNo; 
	} 
	public void setTrainNo(String trainNo) 
	{ 
		this.trainNo = trainNo; 
	} 
	public int getSeatsBooked() 
	{ 
		return seatsBooked; 
	} 
	public void setSeatsBooked(int seatsBooked) 
	{ 
		this.seatsBooked = seatsBooked; 
	} 
	public String getQuota() 
	{ 
		return quota; 
	} 
	public void setQuota(String quota) 
	{ 
		this.quota = quota; 
	} 
	public String getPaymentStatus() 
	{ 
		return paymentStatus; 
	} 
	public void setPaymentStatus(String paymentStatus) 
	{ 
		this.paymentStatus = paymentStatus; 
	} 
	public Timestamp getBookingTime() 
	{ 
		return bookingTime; 
	} 
	public void setBookingTime(Timestamp bookingTime) 
	{ 
		this.bookingTime = bookingTime; 
	} 
}