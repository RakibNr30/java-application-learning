package com.springcore.collections.standalone;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Student {
    private int id;

    private String name;

    private List<String> friends;

    private Map<String, Integer> courseFees;

    private Properties properties;

    public Student() {}

    public Student(int id, String name, List<String> friends, Map<String, Integer> courseFees, Properties properties) {
        this.id = id;
        this.name = name;
        this.friends = friends;
        this.courseFees = courseFees;
        this.properties = properties;
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

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Map<String, Integer> getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(Map<String, Integer> courseFees) {
        this.courseFees = courseFees;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friends=" + friends +
                ", courseFees=" + courseFees +
                ", properties=" + properties +
                '}';
    }
}
