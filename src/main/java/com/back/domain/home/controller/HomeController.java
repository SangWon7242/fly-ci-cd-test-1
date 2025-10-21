package com.back.domain.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@Slf4j
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

    System.out.println("모든 환경에서 출력");
    // log.info("개발/운영 환경에서만 출력");
    log.debug("개발/테스트 환경에서만 출력"); // 운영환경에서는 안나옴

    return "main(execution : 2nd-1), hostname : %s".formatted(localHost.getHostName());
  }
}
