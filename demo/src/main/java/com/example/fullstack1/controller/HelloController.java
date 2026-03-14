package com.example.fullstack1.controller;

import com.example.fullstack1.model.AddResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/add")
    public AddResponse add(@RequestParam double a, @RequestParam double b) {

        double result = a + b;

        return new AddResponse(a, b, result, "Addition successful");

    }
}