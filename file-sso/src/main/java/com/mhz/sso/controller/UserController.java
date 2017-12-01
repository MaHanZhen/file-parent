package com.mhz.sso.controller;

import com.mhz.common.pojo.TbUser;
import com.mhz.common.utils.Msg;
import com.mhz.sso.service.LoginService;
import com.mhz.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/login")
    @ResponseBody
    public Msg doLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        return loginService.doLogin(username, password, request, response);
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Msg getUserByToken(String token) {
        return loginService.getUserByToken(token);
    }

    @RequestMapping("/register")
    @ResponseBody
    public Msg doRegister(TbUser user) {
        return registerService.doRegister(user);
    }

}
