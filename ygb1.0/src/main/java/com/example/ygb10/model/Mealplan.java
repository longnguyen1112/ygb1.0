package com.example.ygb10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="mealplan")
public class Mealplan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mealplan_generator")
    private Long meal_id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="service_id",nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Column(name="meal_desc")
    private String meal_desc;

    @Column(name="meal_in_day")
    private String meal_in_day;

    @Column(name="day_in_week")
    private String day_in_week;

    public Mealplan()
    {

    }

    @Override
    public String toString() {
        return "Mealplan{" +
                "meal_id=" + meal_id +
                ", meal_desc='" + meal_desc + '\'' +
                ", meal_in_day='" + meal_in_day + '\'' +
                ", day_in_week='" + day_in_week + '\'' +
                '}';
    }

    public void setMeal_desc(String meal_desc) {
        this.meal_desc = meal_desc;
    }

    public void setMeal_in_day(String meal_in_day) {
        this.meal_in_day = meal_in_day;
    }

    public void setDay_in_week(String day_in_week) {
        this.day_in_week = day_in_week;
    }

    public Long getMeal_id() {
        return meal_id;
    }

    public String getMeal_desc() {
        return meal_desc;
    }

    public String getMeal_in_day() {
        return meal_in_day;
    }

    public String getDay_in_week() {
        return day_in_week;
    }
}
