package com.mhz.select.service.impl;

import com.github.pagehelper.PageHelper;
import com.mhz.common.mapper.TbDepartmentMapper;
import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.pojo.TbDepartmentExample;
import com.mhz.common.utils.Msg;
import com.mhz.select.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private TbDepartmentMapper departmentMapper;

    @Override
    public EasyUIDataGridResult getDepartmentDataGridList(Integer page, Integer rows) {

        EasyUIDataGridResult gridResult = new EasyUIDataGridResult();
        PageHelper.startPage(page, rows);
        TbDepartmentExample example = new TbDepartmentExample();
        TbDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte)1);
        List<TbDepartment> tbDepartments = departmentMapper.selectByExample(example);
        gridResult.setTotal(tbDepartments.size());
        gridResult.setRows(tbDepartments);

        return gridResult;
    }

    @Override
    public List<TbDepartment> getDepartmentInputList() {
        TbDepartmentExample example = new TbDepartmentExample();
        TbDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte)1);
        List<TbDepartment> tbDepartments = departmentMapper.selectByExample(example);
        return tbDepartments;
    }


}
