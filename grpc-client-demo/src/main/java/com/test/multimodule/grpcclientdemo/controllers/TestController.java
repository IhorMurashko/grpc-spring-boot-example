package com.test.multimodule.grpcclientdemo.controllers;

import com.test.multimodule.grpcclientdemo.grpcClientService.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * REST controller for handling HTTP requests and interacting with the gRPC client service.
 * This controller provides an endpoint to trigger the gRPC greeting functionality.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    /**
     * Constructs a TestController with the specified gRPC client service.
     */
    private final GrpcClientService grpcClientService;

    @Autowired
    public TestController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    /**
     * HTTP GET endpoint to test gRPC communication.
     * <p>
     * This endpoint receives a name in the URL path and forwards it to the gRPC client.
     * The gRPC client then sends the name to the server and returns the server's response.
     *
     * @param name The name provided in the URL path.
     * @return The greeting message from the gRPC server.
     */
    @GetMapping("/t/{name}")
    public String test(@PathVariable("name") String name) {

        return grpcClientService.sayHello(name);
    }


}
