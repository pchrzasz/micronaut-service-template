FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/micronaut-template-native-image
WORKDIR /home/app/micronaut-template-native-image

RUN native-image --no-server --allow-incomplete-classpath \
--initialize-at-run-time=io.micronaut.tracing.brave.instrument.http.HttpClientTracingPublisher \
--initialize-at-build-time=reactor.core.publisher.Flux --initialize-at-build-time=reactor.core.publisher.Mono \
--initialize-at-run-time=io.micronaut.tracing.brave.instrument.http.BraveTracingServerFilter \
-cp build/libs/microservice-template-all.jar


FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-template-native-image/micronaut-template-graalvm /app/micronaut-template-graalvm
ENTRYPOINT ["/app/micronaut-template-graalvm"]
