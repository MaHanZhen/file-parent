package com.mhz.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/{page}")
    public String getPage(@PathVariable String page) {
        return page;
    }
}
