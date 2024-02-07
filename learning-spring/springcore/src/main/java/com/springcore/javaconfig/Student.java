package com.springcore.javaconfig;

import java.util.List;

public class Student {
    private int id;

    private String name;

    private List<String> mobiles;

    private Address address;

    public Student () {}

    public Student(int id, String name, List<String> mobiles, Address address) {
        this.id = id;
        this.name = name;
        this.mobiles = mobiles;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobiles=" + mobiles +
                ", address=" + address +
                '}';
    }
}
