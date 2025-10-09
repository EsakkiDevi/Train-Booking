package model; 
public class Train 
{ 
	private String trainNo; 
	private String name; 
	private String departureTime; 
	private String arrivalTime; 
	private String duration; 
	private int seatsAvailable; 
	private String source; 
	private String destination; 
	private double fare; 
	public String getTrainNo() 
	{ 
		return trainNo; 
	} 
	public void setTrainNo(String trainNo) 
	{ 
		this.trainNo = trainNo; 
	} 
	public String getName() 
	{ 
		return name; 
	} 
	public void setName(String name) 
	{ 
		this.name = name; 
	} 
	public String getDepartureTime() 
	{ 
		return departureTime; 
	} 
	public void setDepartureTime(String departureTime) 
	{ 
		this.departureTime = departureTime; 
	} 
	public String getArrivalTime() 
	{ 
	return arrivalTime; 
	} 
	public void setArrivalTime(String arrivalTime) 
	{ 
		this.arrivalTime = arrivalTime; 
	} 
	public String getDuration() 
	{ 
		return duration; 
	} 
	public void setDuration(String duration) 
	{ 
		this.duration = duration; 
	}
	public int getSeatsAvailable() 
	{ 
		return seatsAvailable; 
	} 
	public void setSeatsAvailable(int seatsAvailable) 
	{ 
		this.seatsAvailable = seatsAvailable; 
	} 
	public String getSource() 
	{ 
		return source; 
	} 
	public void setSource(String source) 
	{ 
		this.source = source; 
	} 
	public String getDestination() 
	{ 
		return destination; 
	} 
	public void setDestination(String destination) 
	{ 
		this.destination = destination; 
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