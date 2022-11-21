package com.example.ygb10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="workoutplan")
public class Workoutplan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "workoutplan_generator")
    private Long workout_id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="service_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Service service;

    @Column(name="workout_desc")
    private String workout_desc;

    @Column(name="set_rep")
    private String set_rep;

    @Column(name="day_in_week")
    private String day_in_week;

    public Workoutplan(){

    }

    @Override
    public String toString() {
        return "Workoutplan{" +
                "workout_id=" + workout_id +
                ", service=" + service +
                ", workout_desc='" + workout_desc + '\'' +
                ", set_rep='" + set_rep + '\'' +
                ", day_in_week='" + day_in_week + '\'' +
                '}';
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setWorkout_desc(String workout_desc) {
        this.workout_desc = workout_desc;
    }

    public void setSet_rep(String set_rep) {
        this.set_rep = set_rep;
    }

    public void setDay_in_week(String day_in_week) {
        this.day_in_week = day_in_week;
    }

    public Long getWorkout_id() {
        return workout_id;
    }

    public Service getService() {
        return service;
    }

    public String getWorkout_desc() {
        return workout_desc;
    }

    public String getSet_rep() {
        return set_rep;
    }

    public String getDay_in_week() {
        return day_in_week;
    }
}
