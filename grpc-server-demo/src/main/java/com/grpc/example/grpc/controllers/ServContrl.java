package com.grpc.example.grpc.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serv")
public class ServContrl {


    @GetMapping("/t")
    public String test() {
        return "Hello World!";
    }

}
