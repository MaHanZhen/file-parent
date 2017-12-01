package com.mhz.select.controller;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.utils.Msg;
import com.mhz.select.service.DepartmentService;
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

    @RequestMapping("/dataGridList")
    @ResponseBody
    public EasyUIDataGridResult getDepartmentDataGridList(Integer page, Integer rows) {
        return departmentService.getDepartmentDataGridList(page,rows);
    }


    @RequestMapping("/inputList")
    @ResponseBody
    public List<TbDepartment> getDepartmentInputList(Integer id) {
        return departmentService.getDepartmentInputList();
    }

}
