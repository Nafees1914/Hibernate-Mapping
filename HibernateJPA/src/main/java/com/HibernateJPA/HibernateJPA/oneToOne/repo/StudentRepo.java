package com.HibernateJPA.HibernateJPA.oneToOne.repo;

import com.HibernateJPA.HibernateJPA.oneToOne.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
