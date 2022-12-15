package com.example.ygb10.repository;

import com.example.ygb10.model.Mealplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealplanRepository extends JpaRepository<Mealplan,Long> {
    List<Mealplan> findByService(Long sId);
}


