package com.example.ygb10.model;

import javax.persistence.*;

@Entity
@Table(name="Trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainer_id;

    @Id
    @Column(name="username")
    private String username;

    @Column(name="goal_type")
    private String goal_type;

    @Column(name="gender")
    private String gender;

    public Trainer()
    {

    }

    public Trainer(String username, String goal_type, String gender) {
        this.username = username;
        this.goal_type = goal_type;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainer_id=" + trainer_id +
                ", username='" + username + '\'' +
                ", goal_type='" + goal_type + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Long getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Long trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoal_type() {
        return goal_type;
    }

    public void setGoal_type(String goal_type) {
        this.goal_type = goal_type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
