package com.example.ygb10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "service_generator")
    private Long service_id;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name="trainee_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Trainee trainee;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name="trainer_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Trainer trainer;

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Column(name="duration")
    private int duration;

    @Column(name="type")
    private String type;

    public Service(){

    }


    @Override
    public String toString() {
        return "Service{" +
                "trainee=" + trainee +
                ", trainer=" + trainer +
                ", duration=" + duration +
                ", type='" + type + '\'' +
                '}';
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getService_id() {
        return service_id;
    }

    public int getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }
}
