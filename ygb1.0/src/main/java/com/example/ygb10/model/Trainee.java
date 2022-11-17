package com.example.ygb10.model;

import javax.persistence.*;

@Entity
@Table(name="trainee")
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainee_id;

    @Id
    @Column(name = "username")
    private String username;

    @Column(name="height")
    private String height;

    @Column(name="weight")
    private String weight;

    @Column(name="goal_weight")
    private String goal_weight;

    public Trainee()
    {

    }
    public Trainee(String username, String height, String weight, String goal_weight) {
        this.username = username;
        this.height = height;
        this.weight = weight;
        this.goal_weight = goal_weight;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "trainee_id=" + trainee_id +
                ", username='" + username + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", goal_weight='" + goal_weight + '\'' +
                '}';
    }

    public Long getTrainee_id() {
        return trainee_id;
    }

    public void setTrainee_id(Long trainee_id) {
        this.trainee_id = trainee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
