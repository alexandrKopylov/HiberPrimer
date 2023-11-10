package com.app.pojo;

import javax.persistence.*;

@Entity
public class Adress {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String zipCode;

    @ManyToOne
    private Emplloyee emplloyee;

    public Adress() {
    }

    public Adress(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;

    }

    public Emplloyee getEmplloyee() {
        return emplloyee;
    }

    public void setEmplloyee(Emplloyee emplloyee) {
        this.emplloyee = emplloyee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
