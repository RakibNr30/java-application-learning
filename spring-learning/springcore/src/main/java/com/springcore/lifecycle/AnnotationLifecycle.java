package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotationLifecycle {
    private int id;

    private String name;

    public AnnotationLifecycle() {}

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

    @Override
    public String toString() {
        return "AnnotationLifecycle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void start() {
        System.out.println("Starting method...");
    }

    @PreDestroy
    public void end() {
        System.out.println("Ending method...");
    }
}
