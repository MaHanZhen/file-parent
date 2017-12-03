package com.mhz.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index(String error, Model model) {
        try {
            if (error != null && "yes".equals(error)) {
                model.addAttribute("error", "用户尚未登录或权限不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping("/{page}")
    public String getPage(@PathVariable String page) {
        return page;
    }
}
