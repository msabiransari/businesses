package com.xdl.businesses.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdl.businesses.model.Business;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BusinessController {

  private List<Business> businesses;

  public BusinessController() {
    try {
      businesses = new ObjectMapper().readValue(new ClassPathResource("/data.json").getInputStream(), new TypeReference<List<Business>>() {
      });
    } catch(Exception e) {
      e.printStackTrace();
      businesses = new ArrayList<>();
    }
  }

  @GetMapping("/")
  public List<Business> getBusinesses() {
    return businesses;
  }

}
