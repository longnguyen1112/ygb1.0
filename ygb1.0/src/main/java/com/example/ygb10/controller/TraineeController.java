package com.example.ygb10.controller;

import com.example.ygb10.exception.ResourceNotFoundException;
import com.example.ygb10.model.*;
import com.example.ygb10.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainee/")
public class TraineeController {
    //4 get, 1 post, 1delete
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

    //view all the trainers (get)
    @GetMapping("/{trainee_id}/trainers")
    public List<Trainer> getAllTrainers(){
        return trainerRepository.findAll();
    }

    //view trainers by their id (get)
    @GetMapping("/{trainee_id}/trainers/{trainer_id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable("trainer_id") Long trainer_id)
    {
        Trainer trainer = trainerRepository.findById(trainer_id)
                .orElseThrow(()->new ResourceNotFoundException("Trainer not exist"+trainer_id));
        return ResponseEntity.ok(trainer);
    }

    //pick trainers (post) which also means create a service
    @PostMapping("/{trainee_id}/trainers/{trainer_id}")
    public ResponseEntity<Service> createService(@PathVariable("trainee_id") Long trainee_id,
    @PathVariable("trainer_id") Long trainer_id,
    @RequestBody Service _service) {
        Trainee currentTrainee = traineeRepository.findById(trainee_id)
                .orElseThrow(()->new ResourceNotFoundException("Trainee not exist with id:"+trainee_id));
        Trainer currentTrainer = trainerRepository.findById(trainer_id)
                .orElseThrow(()->new ResourceNotFoundException("Trainer not exist with id:"+trainer_id));
        _service.setTrainee(currentTrainee);
        _service.setTrainer(currentTrainer);
        Service service = serviceRepository.save(_service);
        return new ResponseEntity<>(service, HttpStatus.CREATED);
    }
    //it works with findAll but not find by service
    @GetMapping("/{trainee_id}/services/{service_id}/mealplan")
    public ResponseEntity<List<Mealplan>> getAllMealsByServiceId(@PathVariable("service_id") Long service_id)
    {
        if(!serviceRepository.existsById(service_id)){
            throw new ResourceNotFoundException("Service not found!");
        }
        //List<Mealplan> mealplans = mealplanRepository.findAll();
        List<Mealplan> mealplans = mealplanRepository.findByService(service_id);
        return new ResponseEntity<>(mealplans,HttpStatus.OK);
    }
    /*@GetMapping("/{trainee_id}/services/{service_id}/workout")
    public ResponseEntity<List<Workoutplan>> getAllWorkoutsByServiceId(@PathVariable("service_id") Long service_id)
    {
        if(!serviceRepository.existsById(service_id)){
            throw new ResourceNotFoundException("Service not found!");
        }
        List<Workoutplan> workoutplans = workoutplanRepository.findByServiceId(service_id);
        return new ResponseEntity<>(workoutplans,HttpStatus.OK);
    }*/

}
