package com.pchrzasz;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import java.util.List;

import static com.pchrzasz.infrastructure.conf.EnvironmentsReader.getEnvironments;

@OpenAPIDefinition(
    info = @Info(
        title = "microservice-template",
        version = "0.0"
    )
)
public class Application {

    public static void main(String[] args) {
        List<String> environments = getEnvironments();

        Micronaut.build(args)
                 .mainClass(Application.class)
                 .environments(environments.toArray(new String[0]))
                 .start();
    }
}
