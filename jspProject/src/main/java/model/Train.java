package model;
public class Train {
    private int trainNo;
    private String name;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int seatsAvailable;
    private double fare;

    // Constructor
    public Train(int trainNo, String name, String source, String destination,
                 String departureTime, String arrivalTime, int seatsAvailable, double fare) {
        this.trainNo = trainNo;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatsAvailable = seatsAvailable;
        this.fare = fare;
    }

    // Getters
    public int getTrainNo() { return trainNo; }
    public String getName() { return name; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public int getSeatsAvailable() { return seatsAvailable; }
    public double getFare() { return fare; }
}
