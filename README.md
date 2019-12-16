# netifi-springboot-example-screencast
Example code for the [Getting Started with Netifi and Spring Boot](https://www.youtube.com/watch?v=rKf1SVR9hwA) screencast.

## Instructions
This is the blank template that was used to start the project in the video. Follow along and add code to complete the
project. 

If you get stuck, the `solution` branch contains the final code.

## Project Structure
This example contains the following interesting projects / directories:

- [docker](docker) - Docker Compose configuration for running a Netifi Broker.
- [hello-client](hello-client) - RSocket client that calls the `hello-service` and requests a hello.
- [hello-service](hello-service) - RSocket service that returns hello messages.
- [hello-service-idl](hello-service-idl) - Protobuf contract that defines the API of the `hello-service` and is used to generate both the service and client code.

## Building the Example
Run the following command to build the example:

    ./gradlew clean build
    
## Running the Example
Follow the steps below to run the example:

1. Ensure you have a running Netifi Broker. If not, run the following commands to start a new broker:

        cd docker
        docker-compose up
        
2. In a new terminal, run the following command to start the `hello-service`:

        ./gradlew :hello-service:bootRun
        
3. In a new terminal, run the following command to start the `hello-client` and send a request to the `hello-service`:

        ./gradlew :hello-client:bootRun

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/netifi-springboot-example-screencast/issues).

## Support
Support for Netifi and RSocket is available on the [Netifi Community Forums](https://community.netifi.com).

## License
Copyright 2019 Netifi Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.