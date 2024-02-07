package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InterfaceLifecycle implements InitializingBean, DisposableBean {
    private int id;

    private String name;

    public InterfaceLifecycle() {}

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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After init... interface lifecycle...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Before destroy... interface lifecycle...");
    }
}
