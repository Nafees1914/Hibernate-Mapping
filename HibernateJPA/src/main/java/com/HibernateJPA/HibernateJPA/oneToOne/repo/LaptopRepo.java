package com.HibernateJPA.HibernateJPA.oneToOne.repo;

import com.HibernateJPA.HibernateJPA.oneToOne.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Integer> {
}
