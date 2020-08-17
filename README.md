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
- allows for tracing its endpoint (Jaeger end-to-end distributed tracing)
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

## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)

## Feature tracing-jaeger documentation

- [Micronaut Jaeger Tracing documentation](https://docs.micronaut.io/latest/guide/index.html#jaeger)

- [https://www.jaegertracing.io](https://www.jaegertracing.io)

## Feature discovery-eureka documentation

- [Micronaut Eureka Service Discovery documentation](https://docs.micronaut.io/latest/guide/index.html#serviceDiscoveryEureka)

## Feature reactor documentation

- [Micronaut Reactor documentation](https://micronaut-projects.github.io/micronaut-reactor/snapshot/guide/index.html)

## Feature management documentation

- [Micronaut Micronaut Management documentation](https://docs.micronaut.io/latest/guide/index.html#management)

## Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

