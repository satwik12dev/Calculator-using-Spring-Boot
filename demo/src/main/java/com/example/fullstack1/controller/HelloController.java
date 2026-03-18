package com.example.fullstack1.controller;

import com.example.fullstack1.model.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/add")
    public Response add(@RequestParam double a, @RequestParam double b){
        double result = a + b;
        return new Response(a,b,result,"Addition successful");
    }

    @GetMapping("/sub")
    public Response subtract(@RequestParam double a, @RequestParam double b){
        double result = a - b;
        return new Response(a,b,result,"Subtraction successful");
    }
    @GetMapping("/mul")
    public Response multiply(@RequestParam double a, @RequestParam double b){
        double result = a * b;
        return new Response(a,b,result,"Multiplication successful");
    }

    @GetMapping("/div")
    public Response divide(@RequestParam double a, @RequestParam double b){
        if(b == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = a / b;
        return new Response(a,b,result,"Division successful");
    }

    @GetMapping("/mod")
    public Response modulo(@RequestParam double a, @RequestParam double b){
        if(b == 0){
            throw new ArithmeticException("Cannot modulo by zero");
        }
        double result = a % b;
        return new Response(a,b,result,"Modulo successful");
    }

    @GetMapping("/floor")
    public Response floor(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = Math.floor(a / b);
        return new Response(a, b, result, "Floor division successful");
    }
}