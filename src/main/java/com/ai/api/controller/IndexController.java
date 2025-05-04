package com.ai.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 首页 */
@Controller
public class IndexController {

  @RequestMapping(value = {"/", "/index"})
  public String index() {
    return "index";
  }
}
