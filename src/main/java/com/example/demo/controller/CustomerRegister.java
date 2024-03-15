package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Customer;
import com.example.demo.model.Greeting;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CustomerRegister {

    @PostMapping("/register")
    @ResponseBody
    public Customer onPostDataCustomer(@ModelAttribute Customer customer){ 
        return customer;
    }
    

    @GetMapping("/register")
    public String customerRegister(Model model) {
        model.addAttribute("Customer", new Customer());
        return "registerForm/register";
    }
}
