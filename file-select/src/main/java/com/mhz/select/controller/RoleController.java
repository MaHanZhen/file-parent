package com.mhz.select.controller;

import com.mhz.common.pojo.TbRole;
import com.mhz.select.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    @ResponseBody
    public List<TbRole> getRoleList(Integer id){
        return roleService.getRoleList(id);
    }

}
