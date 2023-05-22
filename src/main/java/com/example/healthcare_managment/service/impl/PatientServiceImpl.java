package com.example.healthcare_managment.service.impl;

import com.example.healthcare_managment.entity.Patient;
import com.example.healthcare_managment.repository.PatientRepository;
import com.example.healthcare_managment.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    @Override
    public List<Patient> findAll() {
        List<Patient>patients=patientRepository.findAll();
        return patients;
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deleteById(int id) {
        patientRepository.deleteById(id);
    }
}
