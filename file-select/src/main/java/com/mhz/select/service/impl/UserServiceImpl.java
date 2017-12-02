package com.mhz.select.service.impl;

import com.github.pagehelper.PageHelper;
import com.mhz.common.mapper.TbUserMapper;
import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.pojo.TbUserExample;
import com.mhz.common.utils.Msg;
import com.mhz.select.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public EasyUIDataGridResult getUserList(Integer page, Integer rows) {

        TbUserExample example = new TbUserExample();
        example.createCriteria().andStatusNotEqualTo((byte)0);
        example.setOrderByClause("id desc ");
        PageHelper.startPage(page, rows);
        List<TbUser> tbUsers = userMapper.selectByExample(example);
        EasyUIDataGridResult gridResult = new EasyUIDataGridResult();
        gridResult.setTotal(tbUsers.size());
        gridResult.setRows(tbUsers);

        return gridResult;
    }



}
