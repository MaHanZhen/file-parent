package com.mhz.manager.controller;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.utils.Msg;
import com.mhz.manager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/create")
    @ResponseBody
    public Msg addNode(String department) throws Exception {
        return departmentService.createDepartment(department);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Msg deleteNode(int id) throws Exception {
        return  departmentService.deleteDepartment(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Msg updateNode(TbDepartment department) throws Exception {
        return departmentService.updateDepartment(department);
    }
}
