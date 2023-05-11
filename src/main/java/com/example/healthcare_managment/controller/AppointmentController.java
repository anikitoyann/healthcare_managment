package com.example.healthcare_managment.controller;

import com.example.healthcare_managment.entity.Appointment;
import com.example.healthcare_managment.entity.Doctor;
import com.example.healthcare_managment.entity.Patient;
import com.example.healthcare_managment.repository.AppointmentRepository;
import com.example.healthcare_managment.repository.DoctorRepository;
import com.example.healthcare_managment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;


    @GetMapping()
    public String appointmentsPage(ModelMap modelMap) {
        List<Appointment> all = appointmentRepository.findAll();
        modelMap.addAttribute("appointments", all);
        return "appointments";
    }

    @GetMapping("/add")
    public String appointmentsAddPage(ModelMap modelMap) {
        List<Doctor> all = doctorRepository.findAll();
        List<Patient> all1 = patientRepository.findAll();
        modelMap.addAttribute("doctors", all);
        modelMap.addAttribute("patients", all1);
        return "addAppointments";
    }

    @PostMapping("/add")
    public String appointmentsAdd( @ModelAttribute Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/remove")
    public String removeAppointments(@RequestParam("id") int id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }


}
