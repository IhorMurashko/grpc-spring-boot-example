package com.test.multimodule.grpcclientdemo.grpcClientService;

import examples.lib.HelloReply;
import examples.lib.HelloRequest;
import examples.lib.MyServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
/**
 * gRPC client service to interact with the MyService gRPC server.
 * This service provides methods to make requests to the gRPC server.
 */
@Service
public class GrpcClientService {

    @GrpcClient("demo-server")
    private MyServiceGrpc.MyServiceBlockingStub myServiceBlockingStub;

    /**
     * Sends a greeting request to the gRPC server and returns the response message.
     *
     * @param name the name to include in the greeting request.
     * @return the greeting message received from the server.
     * <p>
     * This method constructs a HelloRequest with the given name,
     * sends it to the server using the blocking stub,
     * and returns the message from the HelloReply.
     */
    public String sayHello(String name) {
        // Create a gRPC request with the provided name.
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        // Call the gRPC service and get the response.
        HelloReply reply = myServiceBlockingStub.sayHello(request);

        // Return the server's response message.
        return reply.getMessage();
    }

}
