package com.HibernateJPA.HibernateJPA.manyToMany.repo;

import com.HibernateJPA.HibernateJPA.manyToMany.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,String> {
}
