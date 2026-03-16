package com.example.fullstack1.exception;

import com.example.fullstack1.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle divide by zero
    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleArithmeticException(ArithmeticException ex){
        return new Response(0,0,0,ex.getMessage());
    }

    // Handle wrong datatype (example: a=abc)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleTypeMismatch(MethodArgumentTypeMismatchException ex){
        return new Response(0,0,0,"Invalid input. Please enter numbers only.");
    }

    // Handle missing parameters
    @ExceptionHandler(org.springframework.web.bind.MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleMissingParams(Exception ex){
        return new Response(0,0,0,"Missing required parameters.");
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleGeneralException(Exception ex){
        return new Response(0,0,0,"Something went wrong: " + ex.getMessage());
    }
}