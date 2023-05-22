package com.example.healthcare_managment.controller;

import com.example.healthcare_managment.entity.Doctor;
import com.example.healthcare_managment.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RequiredArgsConstructor
@Controller
@RequestMapping("/doctors")
public class DoctorController {

  private final DoctorService doctorService;

    @GetMapping()
    public  String doctorsPage(ModelMap modelMap){
        modelMap.addAttribute("doctors",doctorService.findAll());
        return "doctors";
    }

@GetMapping("/add")
    public String doctorsAddPage(ModelMap modelMap){
       return "addDoctor";
}
    @PostMapping("/add")
    public String itemsAdd(@ModelAttribute Doctor doctor, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        doctorService.save(doctor,multipartFile);
        return "redirect:/doctors";
    }

@GetMapping("/remove")
    public  String removeDoctors(@RequestParam("id") int id){
        doctorService.deleteById(id);
        return "redirect:/doctors";
}



}
