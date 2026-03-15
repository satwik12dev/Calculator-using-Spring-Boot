package com.example.fullstack1.controller;

import com.example.fullstack1.model.AddResponse;
import com.example.fullstack1.model.DevResponse;
import com.example.fullstack1.model.MulResponse;
import com.example.fullstack1.model.SubResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/add")
    public AddResponse add(@RequestParam double a, @RequestParam double b){
        double result = a + b;
        return new AddResponse(a, b, result, "Addition successful");
    }
    
    @GetMapping("/sub")
    public SubResponse subtract(@RequestParam double a, @RequestParam double b){
        double res  = a-b;
        return new SubResponse(a,b,res,"Subtraction Successful");
    }
    @GetMapping("/mul")
    public MulResponse multiplication(@RequestParam double a, @RequestParam double b){
        double res  = a*b;
        return new MulResponse(a,b,res,"Multiplication Successful");
    }
    @GetMapping("/div")
    public DevResponse Division(@RequestParam double a, @RequestParam double b){
        String msg = "";
        double r=0.0;
        if(b==0){
            msg = "DIVISION NOT POSSIBLE";
        } else if (b!=0) {
            msg = "Division Succesfull";
            r = a/b;
        }
        double res  = r;
        return new DevResponse(a,b,res,msg);
    }
}