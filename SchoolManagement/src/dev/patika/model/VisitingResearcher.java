package dev.patika.model;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor{
    private int hourlySalary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(String name, String address, String phone, int hourlySalary) {
        super(name, address, phone);
        this.hourlySalary = hourlySalary;
    }

    public int getSalary() {
        return hourlySalary;
    }

    public void setSalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "salary=" + hourlySalary +
                '}';
    }
}
