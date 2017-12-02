package com.mhz.sso.controller;

import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.utils.Msg;
import com.mhz.sso.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/list")
    @ResponseBody
    public Msg getDepartmentInput() {
        return departmentService.getDepartmentList();
    }
}
