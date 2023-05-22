package com.example.healthcare_managment.controller;

import com.example.healthcare_managment.entity.User;
import com.example.healthcare_managment.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MyControllerAdvice {
    @ModelAttribute("currentUser")
    public User currentUser(@AuthenticationPrincipal CurrentUser currentUser){
        if(currentUser!=null){
           return currentUser.getUser();
        }
        return null;
    }
}
