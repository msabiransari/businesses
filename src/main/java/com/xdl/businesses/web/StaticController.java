package com.xdl.businesses.web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@CrossOrigin
@Controller
public class StaticController {

  @GetMapping("/app.json")
  public String appJson() {
    StringBuilder builder = new StringBuilder();

    try (Stream<String> stream = Files.lines(Paths.get(new ClassPathResource("/static/app.js").getPath()))) {
      stream.forEach(builder::append);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return builder.toString();
  }
}
