package com.pchrzasz.infrastructure.swagger;

import io.micrometer.core.instrument.util.IOUtils;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Hidden;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Hidden
@Controller("/v2/api-docs")
class OpenApiEndpoint {

  private static final String PATH_OPEN_API_FILE = "META-INF/swagger/microservice-template-0.0.yml";
  private String openApiYmlContent;

  @PostConstruct
  public void init() {
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PATH_OPEN_API_FILE);
    openApiYmlContent = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
  }

  @Get
  public String swagger() {
    return openApiYmlContent;
  }
}
