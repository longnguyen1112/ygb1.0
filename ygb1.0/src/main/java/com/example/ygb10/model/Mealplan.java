package com.example.ygb10.model;

import javax.persistence.*;

@Entity
@Table(name="mealplan")
public class Mealplan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainer_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainee_id;

    @Id
    @Column(name="meal_id")
    private Long meal_id;

    @Column(name="meal_desc")
    private String meal_desc;

    @Column(name="time_in_day")
    private String time_in_day;

    public Mealplan(){

    }

    public Mealplan(Long meal_id, String meal_desc, String time_in_day) {
        this.meal_id = meal_id;
        this.meal_desc = meal_desc;
        this.time_in_day = time_in_day;
    }

    @Override
    public String toString() {
        return "Mealplan{" +
                "trainer_id=" + trainer_id +
                ", trainee_id=" + trainee_id +
                ", meal_id=" + meal_id +
                ", meal_desc='" + meal_desc + '\'' +
                ", time_in_day='" + time_in_day + '\'' +
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

    public Long getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(Long meal_id) {
        this.meal_id = meal_id;
    }

    public String getMeal_desc() {
        return meal_desc;
    }

    public void setMeal_desc(String meal_desc) {
        this.meal_desc = meal_desc;
    }

    public String getTime_in_day() {
        return time_in_day;
    }

    public void setTime_in_day(String time_in_day) {
        this.time_in_day = time_in_day;
    }
}
