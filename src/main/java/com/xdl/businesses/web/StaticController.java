package com.xdl.businesses.web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@CrossOrigin(origins = { "http://localhost:8080", "https://10xdl.groovepages.com"})
@RestController
public class StaticController {

  @GetMapping("/app.js")
  public String appJson() {
    StringBuilder builder = new StringBuilder();

    try (BufferedReader stream = new BufferedReader(new InputStreamReader(new ClassPathResource("/app.js").getInputStream()))) {
      String str;
      while((str = stream.readLine()) != null) {
        builder.append(str);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return builder.toString();
  }
}
