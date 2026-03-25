package com.example.fullstack1.controller;
import com.example.fullstack1.model.Response;
import com.example.fullstack1.model.TrigoResponse;
import org.springframework.web.bind.annotation.*;
import com.example.fullstack1.model.squareResponse;

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
            return new Response(a,b,0,"Cannot divide by zero");
        }
        double result = a / b;
        return new Response(a,b,result,"Division successful");
    }
    @GetMapping("/mod")
    public Response modulo(@RequestParam double a, @RequestParam double b){
        if(b == 0){
            return new Response(a,b,0,"Cannot modulo by zero");
        }
        double result = a % b;
        return new Response(a,b,result,"Modulo successful");
    }
    @GetMapping("/floor")
    public Response floor(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            return new Response(a,b,0,"Cannot divide by zero");
        }
        double result = Math.floor(a / b);
        return new Response(a, b, result, "Floor division successful");
    }
    @GetMapping("/square")
    public squareResponse square(@RequestParam double a){
        double res = a * a;
        return new squareResponse(a, res, "Square successful");
    }
    @GetMapping("/root")
    public squareResponse root(@RequestParam double a){
        double res = Math.sqrt(a);
        return  new squareResponse(a,res,"Square root Successful");
    }
    @GetMapping("/log")
    public  Response log(@RequestParam double number,@RequestParam double base){
        if (number <= 0 || base <= 0 || base == 1) {
            throw new IllegalArgumentException("Invalid input: number > 0, base > 0 and base ≠ 1");
        }
        double result = Math.log(number) / Math.log(base);
        return new Response(number,base,result,"Logrithmitic Calculation Successful");
    }
    @GetMapping("/expo")
    public squareResponse expo(@RequestParam double a) {
        double e = 2.71828182846;
        double res = e * a;
        return new squareResponse(a, res, "Exponential Succesfull");
    }
    @GetMapping("/fact")
    public squareResponse factorial(@RequestParam double a){
        long f=1;
        for(int i=1;i<=a;i++){
            f=f*i;
        }
        long res = f;
        return new squareResponse(a,res,"Factorial Successful");
    }
    @GetMapping("/sin")
    public TrigoResponse sinfunc(@RequestParam double a){
        // Convert degrees to radians
        double radians = Math.toRadians(a);
        double result = Math.sin(radians);
        String msg = "Sin("+a+") Succesful";
        return new TrigoResponse(a,result,msg);
    }
    @GetMapping("/cos")
    public TrigoResponse cosfunc(@RequestParam double a){
        double radians = Math.toRadians(a);
        double result = Math.cos(radians);
        if (Math.abs(result) < 1e-10) {
            result = 0;
        }
        String msg = "Cos("+ a+") Succesful";
        return new TrigoResponse(a,result,msg);
    }
    @GetMapping("/tan")
    public TrigoResponse tanfunc(@RequestParam double a){
        double radians = Math.toRadians(a);
        double result = Math.tan(a);
        if (Math.abs(result) < 1e-10) {
            result = 0;
        }
        String msg = "tan("+a+") Succesful";
        return new TrigoResponse(a,result,msg);
    }
    @GetMapping("/sec")
    public TrigoResponse secfunc(@RequestParam double a){
        double radians = Math.toRadians(a);
        double cosValue = Math.cos(radians);
        if (Math.abs(cosValue) < 1e-10) {
            return new TrigoResponse(a, Double.NaN, "sec(" + a + ") Succesful");
        }
        double result = 1 / cosValue;
        String msg = "sec(" + a + ") Successful";
        return new TrigoResponse(a, result, msg);
    }

    @GetMapping("/ten")
    public  squareResponse tenfunc(@RequestParam double a){
        double res = Math.pow(10,a);
        return new squareResponse(a, res, "10^"+a+" successful");
    }
}