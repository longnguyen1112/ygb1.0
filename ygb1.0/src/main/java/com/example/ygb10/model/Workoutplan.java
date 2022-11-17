package com.example.ygb10.model;

import javax.persistence.*;

@Entity
@Table(name="workoutplan")
public class Workoutplan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainer_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainee_id;

    @Id
    @Column(name="wp_id")
    private Long wp_id;

    @Column(name="wp_desc")
    private String wp_desc;

    @Column(name="day_in_week")
    private String day_in_week;

    @Column(name="routinee")
    private String routinee;

    public Workoutplan(){

    }

    public Workoutplan(Long wp_id, String wp_desc, String day_in_week, String routinee) {
        this.wp_id = wp_id;
        this.wp_desc = wp_desc;
        this.day_in_week = day_in_week;
        this.routinee = routinee;
    }

    @Override
    public String toString() {
        return "Workoutplan{" +
                "trainer_id=" + trainer_id +
                ", trainee_id=" + trainee_id +
                ", wp_id=" + wp_id +
                ", wp_desc='" + wp_desc + '\'' +
                ", day_in_week='" + day_in_week + '\'' +
                ", routinee='" + routinee + '\'' +
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

    public Long getWp_id() {
        return wp_id;
    }

    public void setWp_id(Long wp_id) {
        this.wp_id = wp_id;
    }

    public String getWp_desc() {
        return wp_desc;
    }

    public void setWp_desc(String wp_desc) {
        this.wp_desc = wp_desc;
    }

    public String getDay_in_week() {
        return day_in_week;
    }

    public void setDay_in_week(String day_in_week) {
        this.day_in_week = day_in_week;
    }

    public String getRoutinee() {
        return routinee;
    }

    public void setRoutinee(String routinee) {
        this.routinee = routinee;
    }
}
