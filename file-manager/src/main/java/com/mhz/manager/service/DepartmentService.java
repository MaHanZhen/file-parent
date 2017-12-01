package com.mhz.manager.service;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.EasyUITreeNode;
import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.utils.Msg;

import java.util.List;

public interface DepartmentService {

    public EasyUIDataGridResult getDepartmentDataGridList(Integer page,Integer rows);

    public List<TbDepartment> getDepartmentInputList();

    public Msg createDepartment(String department);

    public Msg updateDepartment(TbDepartment department) ;

    public Msg deleteDepartment(int id) ;
}
