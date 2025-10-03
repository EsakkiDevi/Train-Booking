package model;

public class Station {
    private String code;
    private String name;
    private String city;

    public Station(String code, String name, String city) {
        this.code = code;
        this.name = name;
        this.city = city;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getCity() { return city; }
}