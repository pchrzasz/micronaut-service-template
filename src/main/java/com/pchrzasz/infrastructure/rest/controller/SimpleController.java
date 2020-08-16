package com.pchrzasz.infrastructure.rest.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

@Controller
class SimpleController {

  @Get("/hello")
  Mono<String> hello() {
    return Mono.just("Hello World");
  }
}
