package com.example.ygb10.model;

import javax.persistence.*;

@Entity
@Table(name="trainee")
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "trainee_generator")
    private Long trainee_id;

    @Column(name="fname")
    private String firstName;

    @Column(name="lname")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="height")
    private String height;

    @Column(name="weight")
    private String weight;

    @Column(name="goal_weight")
    private String goal_weight;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Trainee()
    {

    }
    public Trainee(String firstName, String lastName, int age, String height, String weight, String goal_weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.goal_weight = goal_weight;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", goal_weight='" + goal_weight + '\'' +
                '}';
    }

    public Long getTrainee_id() {
        return trainee_id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGoal_weight() {
        return goal_weight;
    }

    public void setGoal_weight(String goal_weight) {
        this.goal_weight = goal_weight;
    }

}
