package com.xdl.businesses.model;

import lombok.Data;

@Data
public class Business {
  private Long id;
  private String name;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String phone;
}
