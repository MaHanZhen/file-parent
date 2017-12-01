package com.mhz.select.service;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.utils.Msg;

import java.util.List;

public interface DepartmentService {

    public EasyUIDataGridResult getDepartmentDataGridList(Integer page, Integer rows);

    public List<TbDepartment> getDepartmentInputList();

}
