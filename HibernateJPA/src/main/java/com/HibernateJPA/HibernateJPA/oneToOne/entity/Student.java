package com.HibernateJPA.HibernateJPA.oneToOne.entity;


import com.HibernateJPA.HibernateJPA.oneToOne.entity.Laptop;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String studentName;
    private String about;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Laptop laptop;

    public Student(String studentName, String about, Laptop laptop) {
        this.studentName = studentName;
        this.about = about;
        this.laptop = laptop;
    }

    public Student() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
