package com.HibernateJPA.HibernateJPA.oneToMany.entity;

import com.HibernateJPA.HibernateJPA.oneToMany.entity.Address;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String about;

    //many addresses
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public Person(String name, String about) {
        this.name = name;
        this.about = about;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
