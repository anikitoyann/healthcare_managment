package com.example.healthcare_managment.controller;

import com.example.healthcare_managment.entity.Appointment;
import com.example.healthcare_managment.entity.Doctor;
import com.example.healthcare_managment.entity.Patient;
import com.example.healthcare_managment.repository.AppointmentRepository;
import com.example.healthcare_managment.repository.DoctorRepository;
import com.example.healthcare_managment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/appointments")
    public String AppointmentsPage(ModelMap modelMap) {
        List<Appointment> all = appointmentRepository.findAll();
        modelMap.addAttribute("appointments", all);
        return "appointments";
    }

    @GetMapping("/appointments/add")
    public String AppointmentsAddPage(ModelMap modelMap) {
        List<Doctor> all = doctorRepository.findAll();
        modelMap.addAttribute("doctors",all);
        List<Patient> all1 = patientRepository.findAll();
        modelMap.addAttribute("patients",all1);
        return "addAppointments";
    }

    @PostMapping("appointments/add")
    public String itemsAdd(@ModelAttribute Appointment appointment){

        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments/remove")
    public String removeDoctors(@RequestParam("id") int id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }


}
