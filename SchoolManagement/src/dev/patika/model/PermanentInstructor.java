package dev.patika.model;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{
    private int fixedSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(String name, String address, String phone, int fixedSalary) {
        super(name, address, phone);
        this.fixedSalary = fixedSalary;
    }

    public int getSalary() {
        return fixedSalary;
    }

    public void setSalary(int salary) {
        this.fixedSalary = salary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "salary=" + fixedSalary +
                '}';
    }
}
