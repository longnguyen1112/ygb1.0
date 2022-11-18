package com.example.ygb10.model;

import javax.persistence.*;

@Entity
@Table(name="service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainer_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainee_id;

    @Column(name="duration")
    private int duration;

    public Service(){

    }

    public Service(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Service{" +
                "trainer_id=" + trainer_id +
                ", trainee_id=" + trainee_id +
                ", duration=" + duration +
                '}';
    }

    public Long getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Long trainer_id) {
        this.trainer_id = trainer_id;
    }

    public Long getTrainee_id() {
        return trainee_id;
    }

    public void setTrainee_id(Long trainee_id) {
        this.trainee_id = trainee_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
