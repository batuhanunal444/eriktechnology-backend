package com.batuhan.stationer.repositories;

import com.batuhan.stationer.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
