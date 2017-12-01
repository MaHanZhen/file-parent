package com.mhz.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.mhz.common.mapper.TbDepartmentMapper;
import com.mhz.common.mapper.TbUserMapper;
import com.mhz.common.pojo.*;
import com.mhz.common.utils.HttpClientUtil;
import com.mhz.common.utils.JsonUtils;
import com.mhz.common.utils.Msg;
import com.mhz.manager.service.DepartmentService;
import com.mhz.manager.utils.HttpResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private TbDepartmentMapper departmentMapper;

    @Value("${SELECT_BASE_URL}")
    private String SELECT_BASE_URL;
    @Value("${SELECT_DEPARTMENT_INPUT_LIST}")
    private String SELECT_DEPARTMENT_INPUT_LIST;
    @Value("${SELECT_DEPARTMENT_DATA_GRID_LIST}")
    private String SELECT_DEPARTMENT_DATA_GRID_LIST;


    @Override
    public EasyUIDataGridResult getDepartmentDataGridList(Integer page, Integer rows) {

        String url = SELECT_BASE_URL + SELECT_DEPARTMENT_DATA_GRID_LIST;
        return HttpResultUtils.getEasyUIDataGridResult(url, page, rows);

    }

    @Override
    public List<TbDepartment> getDepartmentInputList() {
        String url = SELECT_BASE_URL + SELECT_DEPARTMENT_INPUT_LIST;
        String result = HttpClientUtil.doGet(url);
        if (!StringUtils.isEmpty(result)) {
            List<TbDepartment> tbDepartments = JsonUtils.jsonToList(result, TbDepartment.class);
            return tbDepartments;
        }
        return null;

    }

    @Override
    public Msg createDepartment(String department) {
        TbDepartment tbDepartment = new TbDepartment();
        tbDepartment.setDepartment(department);
        tbDepartment.setStatus((byte) 1);
        departmentMapper.insert(tbDepartment);
        return Msg.ok();
    }

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public Msg updateDepartment(TbDepartment department) {
        departmentMapper.updateByPrimaryKey(department);
        return Msg.ok();
    }

    @Override
    public Msg deleteDepartment(int id) {
        TbDepartment tbDepartment = departmentMapper.selectByPrimaryKey(id);
        tbDepartment.setStatus((byte) 0);
        departmentMapper.updateByPrimaryKey(tbDepartment);

        //更新部门下用户状态
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andDepIdEqualTo(id);
        criteria.andStatusNotEqualTo((byte)0);
        List<TbUser> tbUsers = userMapper.selectByExample(example);
        for(TbUser user :tbUsers){
            user.setStatus((byte) 2);
            userMapper.updateByPrimaryKey(user);
        }

        return Msg.ok();
    }
}
