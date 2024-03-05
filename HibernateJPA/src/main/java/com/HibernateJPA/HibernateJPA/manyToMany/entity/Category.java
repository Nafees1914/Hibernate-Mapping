package com.HibernateJPA.HibernateJPA.manyToMany.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    private String cId;
    private String tittle;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Category(String cId, String tittle) {
        this.cId = cId;
        this.tittle = tittle;
    }

    public Category() {
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
