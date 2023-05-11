package com.example.healthcare_managment.repository;

import com.example.healthcare_managment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
