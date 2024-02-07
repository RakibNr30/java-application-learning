package com.entity;

public class User {
    private long id;
    private String name;
    private String email;
    private String mobile;

    public User(int id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMobile() {
        return this.mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", mobile='" + this.mobile + '\'' +
                '}';
    }
}
