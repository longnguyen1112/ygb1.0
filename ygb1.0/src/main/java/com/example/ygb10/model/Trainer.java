package com.example.ygb10.model;

import javax.persistence.*;

@Entity
@Table(name="trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="trainer_generator")
    private Long trainer_id;

    @Column(name="fname")
    private String firstName;

    @Column(name="lname")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="gender")
    private String gender;

    @Column(name="certificate")
    private String certificate;

    public Trainer()
    {

    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainer_id=" + trainer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", certificate='" + certificate + '\'' +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Long getTrainer_id() {
        return trainer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCertificate() {
        return certificate;
    }
}
