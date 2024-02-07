package com.springcore.javaconfig;

public class Address {
    private int id;

    private String street;

    private String city;

    public Address() {}

    public Address(int id, String street, String city) {
        this.id = id;
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
