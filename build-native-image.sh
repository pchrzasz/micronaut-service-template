#!/bin/sh
./gradlew assemble
native-image --no-server --allow-incomplete-classpath --initialize-at-run-time=io.micronaut.tracing.brave.instrument.http.HttpClientTracingPublisher --initialize-at-build-time=reactor.core.publisher.Flux --initialize-at-build-time=reactor.core.publisher.Mono --initialize-at-run-time=io.micronaut.tracing.brave.instrument.http.BraveTracingServerFilter -cp build/libs/microservice-template-all.jar
