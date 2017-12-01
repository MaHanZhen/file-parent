package com.mhz.select.controller;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.select.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/dataGridList")
    @ResponseBody
    public EasyUIDataGridResult getUserList(Integer page, Integer rows) {
        return userService.getUserList(page, rows);
    }


}
