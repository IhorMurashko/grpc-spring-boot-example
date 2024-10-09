package com.test.multimodule.grpcclientdemo.controllers;

import com.test.multimodule.grpcclientdemo.grpcClientService.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final GrpcClientService grpcClientService;

    @Autowired
    public TestController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }


    @GetMapping("/t/{name}")
    public String test(@PathVariable("name") String name) {

        return grpcClientService.sayHello(name);
    }


}
