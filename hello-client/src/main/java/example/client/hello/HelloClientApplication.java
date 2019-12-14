package example.client.hello;

import com.netifi.spring.core.annotation.Group;
import example.service.hello.protobuf.HelloRequest;
import example.service.hello.protobuf.HelloServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class HelloClientApplication {
    private static final Logger LOG = LoggerFactory.getLogger(HelloClientApplication.class);

    public static void main(String... args) {
        SpringApplication.run(HelloClientApplication.class, args);
    }

    /**
     * Runs the client.
     */
    @Component
    public class Runner implements CommandLineRunner {

        @Group(value = "example.service.hello")
        private HelloServiceClient helloServiceClient;

        @Override
        public void run(String... args) throws Exception {
            String name = getNameFromArgs(args);

            // Create the request to send to the service
            HelloRequest request = HelloRequest.newBuilder()
                    .setName(name)
                    .build();

            // Call the service
            helloServiceClient.getHelloMessage(request)
                    .subscribe(helloResponse -> {
                        LOG.info("Response: {}", helloResponse.getMessage());
                    });
        }

        private String getNameFromArgs(String... args) {
            if (args == null || args.length <= 0) {
                return "You";
            } else {
                return args[0];
            }
        }
    }
}
