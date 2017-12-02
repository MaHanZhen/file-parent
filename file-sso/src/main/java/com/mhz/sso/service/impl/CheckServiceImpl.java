package com.mhz.sso.service.impl;

import com.mhz.common.mapper.TbUserMapper;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.pojo.TbUserExample;
import com.mhz.common.utils.Msg;
import com.mhz.sso.pojo.BootstrapValidatorRemote;
import com.mhz.sso.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private TbUserMapper userMapper;


    @Override
    public BootstrapValidatorRemote checkData(Integer type, String username,String email) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo((byte) 0);
        if (type == 1) {
            criteria.andUsernameEqualTo(username);
        } else if (type == 2) {
            criteria.andEmailEqualTo(email);
        }

        List<TbUser> tbUsers = userMapper.selectByExample(example);
        BootstrapValidatorRemote remote = new BootstrapValidatorRemote();
        if (tbUsers == null || tbUsers.size() == 0) {
            remote.setValid(true);
        } else {
            remote.setValid(false);
        }

        return remote;
    }
}
