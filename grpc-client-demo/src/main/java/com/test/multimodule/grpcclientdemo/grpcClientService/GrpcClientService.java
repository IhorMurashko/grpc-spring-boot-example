package com.test.multimodule.grpcclientdemo.grpcClientService;

import examples.lib.HelloReply;
import examples.lib.HelloRequest;
import examples.lib.MyServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("demo-server")
    private MyServiceGrpc.MyServiceBlockingStub myServiceBlockingStub;


    public String sayHello(String name) {

        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        HelloReply reply = myServiceBlockingStub.sayHello(request);


        return  reply.getMessage();
    }

}
