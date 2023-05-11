package com.example.healthcare_managment.repository;

import com.example.healthcare_managment.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
