package com.example.healthcare_managment.controller;
import com.example.healthcare_managment.entity.Patient;
import com.example.healthcare_managment.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping()
    public String patientsPage(ModelMap modelMap) {
        modelMap.addAttribute("patients", patientService.findAll());
        return "patients";
    }

    @GetMapping("/add")
    public String doctorsAddPage(ModelMap modelMap) {
        return "addPatient";
    }

    @PostMapping("/add")
    public String itemsAdd(@ModelAttribute Patient patient) {
        patientService.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/remove")
    public String removeDoctors(@RequestParam("id") int id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }


}
