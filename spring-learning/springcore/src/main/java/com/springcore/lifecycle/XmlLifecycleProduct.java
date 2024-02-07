package com.springcore.lifecycle;

public class XmlLifecycleProduct {
    private int id;

    private String name;

    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("setting id...");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void customInit() {
        System.out.println("Inside init...");
    }

    public void customDestroy() {
        System.out.println("Inside destroy...");
    }
}
