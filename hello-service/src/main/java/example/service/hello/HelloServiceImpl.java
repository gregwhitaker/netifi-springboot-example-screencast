package example.service.hello;

import example.service.hello.protobuf.HelloRequest;
import example.service.hello.protobuf.HelloResponse;
import example.service.hello.protobuf.HelloService;
import io.netty.buffer.ByteBuf;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public Mono<HelloResponse> getHelloMessage(HelloRequest message, ByteBuf metadata) {
        return Mono.fromSupplier(() -> HelloResponse.newBuilder()
                .setMessage(String.format("Hello, %s!", message.getName()))
                .build());
    }
}
