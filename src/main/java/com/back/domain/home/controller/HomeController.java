package com.back.domain.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class HomeController {
  @GetMapping("/")
  @ResponseBody
  public String main() {
    InetAddress localHost = null;
    try {
      localHost = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      throw new RuntimeException(e);
    }

    return "main(execution : 2nd-1), hostname : %s".formatted(localHost.getHostName());
  }
}
