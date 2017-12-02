package com.mhz.sso.service.impl;

import com.mhz.common.mapper.TbDepartmentMapper;
import com.mhz.common.mapper.TbUserMapper;
import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.pojo.TbUserExample;
import com.mhz.common.utils.Msg;
import com.mhz.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private TbDepartmentMapper departmentMapper;

    @Value("${DEFAULT_USER_TYPE}")
    private byte DEFAULT_USER_TYPE;
    @Value("${DEFAULT_USER_ROLE}")
    private String DEFAULT_USER_ROLE;
    @Value("${DEFAULT_USER_STATUS}")
    private byte DEFAULT_USER_STATUS;

    @Override
    public Msg doRegister(TbUser user) {

        TbUserExample example = new TbUserExample();

        example.or().andUsernameEqualTo(user.getUsername()).andStatusNotEqualTo((byte) 0);
        example.or().andEmailEqualTo(user.getEmail()).andStatusNotEqualTo((byte) 0);

        List<TbUser> tbUsers = userMapper.selectByExample(example);
        if (tbUsers != null && tbUsers.size() > 0) {
            return Msg.build(400, "该用户名或邮箱已经被使用");
        }

        // 补全信息
        //可以考虑使用后JS同时传入部门信息
        TbDepartment tbDepartment = departmentMapper.selectByPrimaryKey(user.getDepId());
        user.setDepartment(tbDepartment.getDepartment());
        user.setrId(DEFAULT_USER_TYPE);
        user.setRole(DEFAULT_USER_ROLE);
        user.setStatus(DEFAULT_USER_STATUS);

        //密码MD5加密
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        userMapper.insert(user);
        return Msg.ok();
    }
}
