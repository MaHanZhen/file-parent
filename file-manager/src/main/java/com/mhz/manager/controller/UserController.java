package com.mhz.manager.controller;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.utils.Msg;
import com.mhz.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getUserList(Integer page,Integer rows){
        return  userService.getUserList(page,rows);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Msg updateUser(TbUser user){
        return userService.updateUser(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Msg removeUser(int id){
        return userService.removeUser(id);
    }

}
