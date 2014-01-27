package com.pivotallabs.scratch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final Model model;

  public HelloController() {
    model = new Model();
  }

  @RequestMapping("/")
  public String index() {
    return "Hello " + model.getValue();
  }
}
