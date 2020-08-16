package com.pchrzasz.infrastructure.swagger;

import com.pchrzasz.resources.TestResourceFileLoader;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
class OpenApiEndpointTest {

  @Inject
  @Client("/")
  private RxHttpClient client;

  @Test
  void shouldReturnOpenApiDefinition() {
    String expectedOpenApiDefinition = TestResourceFileLoader.loadFileContentFromResources("swagger/api-doc.yml");

    final String result = client.toBlocking().retrieve(HttpRequest.GET("/v2/api-docs"), String.class);

    assertThat(result).isEqualTo(expectedOpenApiDefinition);
  }
}
