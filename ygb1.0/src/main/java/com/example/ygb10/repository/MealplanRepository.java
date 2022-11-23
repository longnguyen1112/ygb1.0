package com.example.ygb10.repository;

import com.example.ygb10.model.Mealplan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealplanRepository extends JpaRepository<Mealplan,Long> {
    //List<Mealplan> findByServiceId(Long sId);
}
