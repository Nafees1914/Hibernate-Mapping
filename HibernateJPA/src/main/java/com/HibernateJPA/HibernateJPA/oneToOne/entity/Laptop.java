package com.HibernateJPA.HibernateJPA.oneToOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laptopId;
    private String modelName;
    private String about;

    @OneToOne()
    @JoinColumn(name = "student_id")
    private Student student;

    public Laptop(String modelName, String about, Student student) {
        this.modelName = modelName;
        this.about = about;
        this.student = student;
    }

    public Laptop() {
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", modelName='" + modelName + '\'' +
                ", about='" + about + '\'' +
                ", student=" + student +
                '}';
    }
}
