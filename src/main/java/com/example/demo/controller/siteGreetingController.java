package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class siteGreetingController {

    @GetMapping("")
    public String homePage(Model myModel){
        System.out.println("=========home-=========");
        myModel.addAttribute("namePage", "homePage");
        return "layout/main";
    } 
    
}
