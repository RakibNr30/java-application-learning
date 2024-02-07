package com.springcore.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("student1")
@Scope("prototype")
public class Student {
    @Value("1")
    private int id;

    @Value("Abdur Rakib")
    private String name;

    @Value("Mymensingh")
    private String address;

    @Value("#{myFriends1}")
    private List<String> friends;

    public Student() {}

    public Student(int id, String name, String address, List<String> friends) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.friends = friends;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", friends=" + friends +
                '}';
    }
}
