package com.example.healthcare_managment.service;

import com.example.healthcare_managment.entity.Doctor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DoctorService {

    List<Doctor> findAll();

    void save(Doctor doctor, MultipartFile multipartFile) throws IOException;

    void deleteById(int id);
}
