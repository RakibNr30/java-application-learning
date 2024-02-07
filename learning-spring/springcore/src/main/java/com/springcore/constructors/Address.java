package com.springcore.constructors;

public class Address {
    private int id;

    private String city;

    private String division;

    public Address() {}

    public Address(int id, String city, String division) {
        this.id = id;
        this.city = city;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
