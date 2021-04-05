package com.duytran.service;

import com.duytran.grpc.HelloReply;
import com.duytran.grpc.HelloRequest;
import com.duytran.grpc.MutinyGreeterGrpc;
import io.smallrye.mutiny.Uni;

public class ReactiveHelloService extends MutinyGreeterGrpc.GreeterImplBase {
    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item( () ->
                HelloReply.newBuilder().setMessage("Hello" + request.getName()).build());
    }
}
