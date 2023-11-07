package com.app.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emplloyee {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;
    @OneToMany
    private List<Adress> adresses = new ArrayList<>();

    public Emplloyee() {
    }

    public Emplloyee(String firstName, String lastName, int age, List<Adress> adresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.adresses = adresses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }
}
