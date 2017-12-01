package com.mhz.select.service.impl;

import com.mhz.common.mapper.TbRoleMapper;
import com.mhz.common.pojo.TbRole;
import com.mhz.common.pojo.TbRoleExample;
import com.mhz.select.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private TbRoleMapper roleMapper;

    @Override
    public List<TbRole> getRoleList(Integer id) {
        TbRoleExample example = new TbRoleExample();
        if(id!=null) {
            TbRoleExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(Byte.parseByte(id+""));
        }
        return roleMapper.selectByExample(example);
    }
}
