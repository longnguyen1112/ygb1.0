package com.example.ygb10.repository;

import com.example.ygb10.model.Workoutplan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutplanRepository extends JpaRepository<Workoutplan,Long> {
    //List<Workoutplan> findByServiceId(Long sId);
}
