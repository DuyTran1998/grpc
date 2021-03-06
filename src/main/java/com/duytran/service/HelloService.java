package com.duytran.service;

import com.duytran.grpc.GreeterGrpc;
import com.duytran.grpc.HelloReply;
import com.duytran.grpc.HelloRequest;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class HelloService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        String message = "Hello " + name;

        responseObserver.onNext(HelloReply.newBuilder().setMessage(message).build());
        responseObserver.onCompleted();
    }
}
