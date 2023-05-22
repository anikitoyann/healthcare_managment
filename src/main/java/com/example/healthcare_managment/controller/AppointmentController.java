package com.example.healthcare_managment.controller;

import com.example.healthcare_managment.entity.Appointment;
import com.example.healthcare_managment.security.CurrentUser;
import com.example.healthcare_managment.service.AppointmentService;
import com.example.healthcare_managment.service.DoctorService;
import com.example.healthcare_managment.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private  final PatientService patientService;
    @GetMapping()
    public String appointmentsPage(ModelMap modelMap) {

        modelMap.addAttribute("appointments", appointmentService.findAll());
        return "appointments";
    }
    @GetMapping("/add")
    public String appointmentsAddPage(ModelMap modelMap) {
        modelMap.addAttribute("doctors", doctorService.findAll());
        modelMap.addAttribute("patients", patientService.findAll());
        return "addAppointments";
    }
    @PostMapping("/add")
    public String appointmentsAdd(@ModelAttribute Appointment appointment,@AuthenticationPrincipal CurrentUser currentUser) {
       appointmentService.save(currentUser.getUser(),appointment);
        return "redirect:/appointments";
    }
    @GetMapping("/remove")
    public String removeAppointments(@RequestParam("id") int id) {
        appointmentService.deleteById(id);
        return "redirect:/appointments";
    }
}
