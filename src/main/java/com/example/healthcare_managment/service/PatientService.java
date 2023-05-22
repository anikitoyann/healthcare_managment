package com.example.healthcare_managment.service;

import com.example.healthcare_managment.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();

    void save(Patient patient);

    void deleteById(int id);
}
