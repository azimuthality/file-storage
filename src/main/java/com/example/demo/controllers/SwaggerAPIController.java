package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RestController
public class SwaggerAPIController {


    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/Hello")
    public String homePage(){
        return "Hello...";
    }


}
