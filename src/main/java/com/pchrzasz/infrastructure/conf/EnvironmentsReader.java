package com.pchrzasz.infrastructure.conf;

import io.micronaut.context.env.Environment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EnvironmentsReader {

  private EnvironmentsReader() {
  }

  public static List<String> getEnvironments() {
    List<String> environments;
    if (System.getenv(Environment.ENVIRONMENTS_ENV) != null) {
      environments = Arrays.asList(System.getenv(Environment.ENVIRONMENTS_ENV).split(","));
    } else if (System.getProperty(Environment.ENVIRONMENTS_PROPERTY) != null) {
      environments = Arrays.asList(System.getProperty(Environment.ENVIRONMENTS_PROPERTY).split(","));
    } else {
      environments = Collections.singletonList("dev");
    }
    return environments;
  }
}
