package com.grpc.example.grpc.services;


import examples.lib.HelloReply;
import examples.lib.HelloRequest;
import examples.lib.MyServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Implementation of the MyService gRPC service.
 * This service is responsible for handling incoming gRPC requests
 * and sending appropriate responses.
 */
@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {


    /**
     * Sends a greeting message in response to a HelloRequest.
     *
     * @param request          the HelloRequest containing the name to greet.
     * @param responseObserver the StreamObserver to send the HelloReply back to the client.
     *                         <p>
     *                         The method constructs a HelloReply message using the name
     *                         received in the HelloRequest and sends it to the client.
     *                         Finally, it completes the response stream.
     */
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        // Create a reply message by appending the name from the request to "Hello".
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();

        // Send the response to the client and complete the request.
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
