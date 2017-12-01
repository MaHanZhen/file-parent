package com.mhz.sso.service.impl;

import com.mhz.common.mapper.TbUserMapper;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.pojo.TbUserExample;
import com.mhz.common.utils.Msg;
import com.mhz.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public Msg doRegister(TbUser user) {

        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo((byte) 0);
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andEmailEqualTo(user.getEmail());

        List<TbUser> tbUsers = userMapper.selectByExample(example);
        if (tbUsers != null || tbUsers.size() > 0) {
            return Msg.build(400, "该用户名或邮箱已经被使用");
        }

        userMapper.insert(user);

        return Msg.ok();
    }
}
