package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dogID;

    private String name;
    private int age;


    public long getDogID() {
        return dogID;
    }

    public void setDogID(long dogID) {
        this.dogID = dogID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogID=" + dogID +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
