# Microservice template

Microservice based on framework Micronaut (Spring alternative) with improvements to create microservice template which 
will be an entrypoint for starting development focusing on business logic instead of infrastructure. 
This service:
- exposes openapi (swagger doc) - `/v2/-api-dcs`
- exposes metrics (support for prometheus) - `/management/metrics`
- exposes healthcheck - `/management/health`
- is using profiles (dev, prod, test) with proper configuration for each one e.g. disabled service discovery in `dev` and enabled in `prod`
- is supporting Netflix Eureka (service discovery)
- build executable .jar using one command: `./gradlew assemble`
- allows creating docker image using one command: `./gradlew jibDockerBuild`
- logging with highlight scheme (errors highlighted with red color)
- exposes dummy endpoint `/hello`
- supports building GraalVM native image
    - outside docker
           
            $ sdk install java 20.1.0.r8-grl
            $ sdk use java 20.1.0.r8-grl
            $ gu install native-image
            $ ./build-native-image.sh
            $ ./micronaut-template-graalvm
            
    - inside docker
    
            $ ./gradlew assemble 
            $ docker build . -t micronaut-template-graalvm
            $ docker run -p 8080:8080 micronaut-template-graalvm

## Technology Stack

- Java 11
- Micronaut
- Gradle
- GraalVM (native image)
- Docker
- Swagger
- Netflix Eureka
