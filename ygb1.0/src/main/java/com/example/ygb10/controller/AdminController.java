package com.example.ygb10.controller;

import com.example.ygb10.exception.ResourceNotFoundException;
import com.example.ygb10.model.Trainer;
import com.example.ygb10.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    TrainerRepository trainerRepository;

    //this will just do 4 basic CRUD
    //first, get request for all and for id
    @GetMapping("trainers")
    public List<Trainer> getAllTrainers(){
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers;
    }

    @GetMapping("/trainers/{trainer_id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable("trainer_id") Long trainer_id)
    {
        Trainer trainer = trainerRepository.findById(trainer_id)
                .orElseThrow(()->new ResourceNotFoundException("Trainer doesnt exist"));
        return ResponseEntity.ok(trainer);
    }

    @PostMapping("/trainer")
    public Trainer createTrainer(@RequestBody Trainer _trainer)
    {
        return trainerRepository.save(_trainer);
    }

    @PutMapping("/trainers/{trainer_id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable("trainer_id") Long trainer_id,
                                                 @RequestBody Trainer _trainer)
    {
        Trainer trainer = trainerRepository.findById(trainer_id)
                .orElseThrow(()->new ResourceNotFoundException("Trainer not found"));
        trainer.setAge(_trainer.getAge());
        trainer.setFirstName(_trainer.getFirstName());
        trainer.setLastName(_trainer.getLastName());
        trainer.setCertificate(_trainer.getCertificate());
        trainer.setGender(_trainer.getGender());

        Trainer updatedTrainer = trainerRepository.save(trainer);
        return ResponseEntity.ok(updatedTrainer);
    }

    @DeleteMapping("/trainers/{trainer_id}")
    public ResponseEntity<Map<String,Boolean>> deleteTrainer(@PathVariable("trainer_id") Long trainer_id)
    {
        Trainer trainer = trainerRepository.findById(trainer_id)
                .orElseThrow(()->new ResourceNotFoundException("trainer not found"));
        trainerRepository.delete(trainer);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
