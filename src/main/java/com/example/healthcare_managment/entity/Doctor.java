package com.example.healthcare_managment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="doctor" )
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String speciality;
    private String phoneNumber;
    @Column(name = "profile_pic")
    private String imgName;
}
