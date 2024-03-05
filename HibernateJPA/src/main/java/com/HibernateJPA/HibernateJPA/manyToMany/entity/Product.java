package com.HibernateJPA.HibernateJPA.manyToMany.entity;

import com.HibernateJPA.HibernateJPA.manyToMany.entity.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private String pId;
    private String productName;
    @ManyToMany(mappedBy = "products")
    private List<Category> categories = new ArrayList<>();

    public Product(String pId, String productName) {
        this.pId = pId;
        this.productName = productName;
    }


    public Product() {
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
