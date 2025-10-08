package model;

public class Passengers {
    private int passengerId;
    private int bookingId;
    private String name;
    private int age;
    private String gender;

    public Passengers() {}

    public Passengers(int bookingId, String name, int age, String gender) {
        this.bookingId = bookingId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // getters and setters
    public int getPassengerId() { return passengerId; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
