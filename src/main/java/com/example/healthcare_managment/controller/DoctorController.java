package com.example.healthcare_managment.controller;

import com.example.healthcare_managment.entity.Doctor;
import com.example.healthcare_managment.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
  private   DoctorRepository doctorRepository;
    @Value("${listam.upload.image.path}")
    private String imageUploadPath;

    @GetMapping()
    public  String doctorsPage(ModelMap modelMap){
        List<Doctor> all=doctorRepository.findAll();
        modelMap.addAttribute("doctors",all);
        return "doctors";
    }

@GetMapping("/add")
    public String doctorsAddPage(ModelMap modelMap){
       return "addDoctor";
}
    @PostMapping("/add")
    public String itemsAdd(@ModelAttribute Doctor doctor, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            doctor.setImgName(fileName);
        }
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }

@GetMapping("/remove")
    public  String removeDoctors(@RequestParam("id") int id){
        doctorRepository.deleteById(id);
        return "redirect:/doctors";
}



}
