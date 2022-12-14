package com.example.ygb10.controller;

import com.example.ygb10.exception.ResourceNotFoundException;
import com.example.ygb10.model.Mealplan;
import com.example.ygb10.model.Service;
import com.example.ygb10.model.Trainee;
import com.example.ygb10.model.Workoutplan;
import com.example.ygb10.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/trainer/")

public class TrainerController {
    @Autowired
    TraineeRepository traineeRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    MealplanRepository mealplanRepository;
    @Autowired
    WorkoutplanRepository workoutplanRepository;

    //view all assigned trainees
    //view all service and then view all trainee in the service
    @GetMapping("/{trainer_id}/service/trainees")
    public List<Service> getAllTrainee() {
        List<Service> services = serviceRepository.findAll();
        //List<Trainee> trainees = Collections.emptyList();
        //services.forEach(service -> {service.getTrainee();});
        //need to ask someone how to map this
        return services;
    }

    //view specific trainee
    @GetMapping("/{trainer_id}/service/{service_id}/trainees/{trainee_id}")
    public ResponseEntity<Trainee> getTraineeByid(@PathVariable("trainee_id") Long trainee_id) {
        //same
        Trainee tempTrainee = traineeRepository.findById(trainee_id)
                .orElseThrow(()->new ResourceNotFoundException("not found"));
        return new ResponseEntity<>(tempTrainee,HttpStatus.OK);
    }

    //assign meal plan
    @PostMapping("/{trainer_id}/service/{service_id}/mealplan")
    public ResponseEntity<Mealplan> createMealplan(@PathVariable("service_id") Long service_id,
                                                   @RequestBody Mealplan mealplan) {
        Service service = serviceRepository.findById(service_id)
                .orElseThrow(()->new ResourceNotFoundException("Service not found!"));
        mealplan.setService(service);
        Mealplan _mealplan = mealplanRepository.save(mealplan);
        return new ResponseEntity<>(_mealplan, HttpStatus.CREATED);
    }

    //assign workout plan
    @PostMapping("/{trainer_id}/service/{service_id}/workoutplan")
    public ResponseEntity<Workoutplan> createWorkoutplan(@PathVariable("service_id") Long service_id,
                                                         @RequestBody Workoutplan workoutplan) {
        Service service = serviceRepository.findById(service_id)
                .orElseThrow(()->new ResourceNotFoundException("Service not found!"));
        workoutplan.setService(service);
        Workoutplan _workoutplan = workoutplanRepository.save(workoutplan);
        return new ResponseEntity<>(_workoutplan, HttpStatus.CREATED);
    }

    //change meal plan
    @PutMapping("/{trainer_id}/service/{service_id}/mealplan/{mealplan_id}")
    public ResponseEntity<Mealplan> updateMealplan(@PathVariable("service_id") Long service_id,
                                                   @PathVariable("mealplan_id") Long mealplan_id,
                                                   @RequestBody Mealplan _mealplan) {
        Service service = serviceRepository.findById(service_id)
                .orElseThrow(()->new ResourceNotFoundException("Service not found!"));
        Mealplan mealplan = mealplanRepository.findById(mealplan_id)
                .orElseThrow(()->new ResourceNotFoundException("Meal plan not found!"));
        mealplan.setService(_mealplan.getService());
        mealplan.setDay_in_week(_mealplan.getDay_in_week());
        mealplan.setMeal_in_day(_mealplan.getMeal_in_day());
        mealplan.setMeal_desc(_mealplan.getMeal_desc());

        return new ResponseEntity<>(mealplanRepository.save(mealplan),HttpStatus.OK);
    }

    //change workout plan
    @PutMapping("/{trainer_id}/service/{service_id}/workoutplan/{workoutplan_id}")
    public ResponseEntity<Workoutplan> updateWorkoutplan(@PathVariable("service_id") Long service_id,
                                                         @PathVariable("workoutplan_id") Long workoutplan_id,
                                                         @RequestBody Workoutplan _workoutplan) {
        Service service = serviceRepository.findById(service_id)
                .orElseThrow(()-> new ResourceNotFoundException("not found"));
        Workoutplan workoutplan = workoutplanRepository.findById(workoutplan_id)
                .orElseThrow(()->new ResourceNotFoundException("not found"));
        workoutplan.setService(_workoutplan.getService());
        workoutplan.setDay_in_week(_workoutplan.getDay_in_week());
        workoutplan.setSet_rep(_workoutplan.getSet_rep());
        workoutplan.setWorkout_desc(_workoutplan.getWorkout_desc());
        return new ResponseEntity<>(workoutplanRepository.save(workoutplan),HttpStatus.OK);
    }
}
