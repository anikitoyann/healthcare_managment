package com.example.healthcare_managment.service;

import com.example.healthcare_managment.entity.Appointment;
import com.example.healthcare_managment.entity.User;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();

    void save(User currentUser,Appointment appointment);

    void deleteById(int id);
}
