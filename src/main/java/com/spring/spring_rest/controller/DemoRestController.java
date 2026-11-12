package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles demo REST endpoints.
 */
@RestController
@RequestMapping("/test")
public class DemoRestController {

  /**
   * Returns a simple Hello World.
   *
   * @return Hello world
   */
  @GetMapping("/hello")
  public String sayHello() {
    return "Hello World!";
  }

}
