package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.model.Greeting;


@Controller
@RequestMapping("/greeting")
public class CustomerGreetingController {

    private static final String content = "Hello %s %s";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/json")
    @ResponseBody
    public Greeting CustomerGreeting(@RequestParam(value = "gender", defaultValue = "0") boolean gender, 
                                     @RequestParam(value = "nameCustomer", defaultValue = "customer") String nameCustomer) {
        return Greeting.builder()
        .id(counter.incrementAndGet())
        .content(String.format(content, gender ? "Mr." : "Ms.", nameCustomer))
        .build();
    }

    @GetMapping("")
    public String greeting(Model myModel) {
        myModel.addAttribute("namePage", "greeting");
        return "layout/main";
    }

}
