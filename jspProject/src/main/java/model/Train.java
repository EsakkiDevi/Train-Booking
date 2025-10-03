package model;

public class Train {
    private String trainNo;
    private String name;
    private String departureTime;
    private String arrivalTime;
    private String duration;
    private int seatsAvailable;

    public Train(String trainNo, String name, String departureTime,
                 String arrivalTime, String duration, int seatsAvailable) {
        this.trainNo = trainNo;
        this.name = name;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.seatsAvailable = seatsAvailable;
    }

    public String getTrainNo() { return trainNo; }
    public String getName() { return name; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public String getDuration() { return duration; }
    public int getSeatsAvailable() { return seatsAvailable; }
}
