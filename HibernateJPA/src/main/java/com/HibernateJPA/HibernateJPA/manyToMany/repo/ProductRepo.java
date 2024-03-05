package com.HibernateJPA.HibernateJPA.manyToMany.repo;

import com.HibernateJPA.HibernateJPA.manyToMany.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,String> {
}
