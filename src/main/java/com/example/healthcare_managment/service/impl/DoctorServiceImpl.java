package com.example.healthcare_managment.service.impl;

import com.example.healthcare_managment.entity.Doctor;
import com.example.healthcare_managment.repository.DoctorRepository;
import com.example.healthcare_managment.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    @Value("${listam.upload.image.path}")
    private String imageUploadPath;
    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public void save(Doctor doctor, MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            doctor.setImgName(fileName);

        }
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteById(int id) {
        doctorRepository.deleteById(id);
    }
}
