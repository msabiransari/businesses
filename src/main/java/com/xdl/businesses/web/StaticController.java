package com.xdl.businesses.web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

@CrossOrigin
@Controller
public class StaticController {

  @GetMapping("/app.json")
  public void appJson(HttpServletResponse response) {
    try {
      InputStream source = new ClassPathResource("/static/app.js").getInputStream();
      OutputStream target = response.getOutputStream();
      byte[] buf = new byte[8192];
      int length;
      while ((length = source.read(buf)) > 0) {
        target.write(buf, 0, length);
      }
      target.close();
      source.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
