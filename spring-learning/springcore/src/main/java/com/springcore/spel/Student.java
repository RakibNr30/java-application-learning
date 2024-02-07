package com.springcore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("1")
    private int id;

    @Value("#{ 63 + 27 }")
    private int javaMarks;

    @Value("#{ 59 + 24 }")
    private int phpMarks;

    @Value("#{ T(Math).sqrt(13) + T(Math).PI }")
    private double grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJavaMarks() {
        return javaMarks;
    }

    public void setJavaMarks(int javaMarks) {
        this.javaMarks = javaMarks;
    }

    public int getPhpMarks() {
        return phpMarks;
    }

    public void setPhpMarks(int phpMarks) {
        this.phpMarks = phpMarks;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", javaMarks=" + javaMarks +
                ", phpMarks=" + phpMarks +
                ", grade=" + grade +
                '}';
    }
}
