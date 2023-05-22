package com.example.healthcare_managment.service.impl;

import com.example.healthcare_managment.entity.Appointment;
import com.example.healthcare_managment.entity.User;
import com.example.healthcare_managment.repository.AppointmentRepository;
import com.example.healthcare_managment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Override
    public List<Appointment> findAll() {
        List<Appointment>appointments=appointmentRepository.findAll();
        return appointments;
    }

    @Override
    public void save(User currentUser, Appointment appointment) {
        appointment.setUser(currentUser);
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteById(int id) {
     appointmentRepository.deleteById(id);
    }
}
