package com.HibernateJPA.HibernateJPA.oneToMany.repo;

import com.HibernateJPA.HibernateJPA.oneToMany.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {
}
