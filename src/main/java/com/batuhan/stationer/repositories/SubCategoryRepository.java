package com.batuhan.stationer.repositories;

import com.batuhan.stationer.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
}