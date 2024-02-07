package com.springcore.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
    private int id;

    private String name;

    private List<String> mobiles;

    private Set<String> addresses;

    private Map<String, String> courses;

    private Properties properties;

    public Student () {}

    public Student(int id, String name, List<String> mobiles, Set<String> addresses, Map<String, String> courses, Properties properties) {
        this.id = id;
        this.name = name;
        this.mobiles = mobiles;
        this.addresses = addresses;
        this.courses = courses;
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

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

    public Set<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }

    public Map<String, String> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, String> courses) {
        this.courses = courses;
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
                ", mobiles=" + mobiles +
                ", addresses=" + addresses +
                ", courses=" + courses +
                ", properties=" + properties +
                '}';
    }
}
