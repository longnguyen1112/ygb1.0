package com.example.ygb10.controller;

import com.example.ygb10.exception.ResourceNotFoundException;
import com.example.ygb10.model.Service;
import com.example.ygb10.model.Trainee;
import com.example.ygb10.model.Trainer;
import com.example.ygb10.repository.ServiceRepository;
import com.example.ygb10.repository.TraineeRepository;
import com.example.ygb10.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Service createService(@PathVariable("trainee_id") Long trainee_id,@PathVariable("trainer_id") Long trainer_id,int duration,String type)
    {
        Trainee currentTrainee = traineeRepository.findById(trainee_id)
                .orElseThrow(()->new ResourceNotFoundException("Trainer not exist"+trainee_id));
        Trainer currentTrainer = trainerRepository.findById(trainer_id)
                .orElseThrow(()->new ResourceNotFoundException("Trainer not exist"+trainer_id));
        Service service = serviceRepository.save(new Service())
    }
}
