package com.mhz.manager.service.impl;

import com.mhz.common.mapper.TbDepartmentMapper;
import com.mhz.common.mapper.TbUserMapper;
import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.pojo.TbDepartmentExample;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.utils.CookieUtils;
import com.mhz.common.utils.HttpClientUtil;
import com.mhz.common.utils.JsonUtils;
import com.mhz.common.utils.Msg;
import com.mhz.manager.service.UserService;
import com.mhz.manager.utils.HttpResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private TbDepartmentMapper departmentMapper;

    @Value("${SELECT_BASE_URL}")
    private String SELECT_BASE_URL;
    @Value("${SELECT_USER_DATA_GRID_LIST}")
    private String SELECT_USER_DATA_GRID_LIST;

    @Value("${SSO_BASE_URL}")
    private String SSO_BASE_URL;
    @Value("${SSO_LOGIN_URL}")
    private String SSO_LOGIN_URL;
    @Value("${SSO_GET_USER_URL}")
    private String SSO_GET_USER_URL;
    @Value("${SSO_USER_LOGOUT_URL}")
    private String SSO_USER_LOGOUT_URL;


    @Override
    public EasyUIDataGridResult getUserList(Integer page, Integer rows) {
        String url = SELECT_BASE_URL + SELECT_USER_DATA_GRID_LIST;
        return HttpResultUtils.getEasyUIDataGridResult(url, page, rows);
    }

    @Override
    public Msg updateUser(TbUser user) {


        TbDepartmentExample example = new TbDepartmentExample();
        TbDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(user.getDepId());
        criteria.andStatusNotEqualTo((byte) 0);
        List<TbDepartment> tbDepartments = departmentMapper.selectByExample(example);
        if (tbDepartments != null && tbDepartments.size() > 0) {
            user.setStatus((byte) 1);
        } else {
            user.setStatus((byte) 2);
        }
        userMapper.updateByPrimaryKey(user);
        return Msg.ok();
    }

    @Override
    public Msg removeUser(int id) {
        TbUser user = userMapper.selectByPrimaryKey(id);
        user.setStatus((byte) 0);
        userMapper.updateByPrimaryKey(user);
        return Msg.ok();
    }

    @Override
    public Msg doLogout(HttpServletRequest request) {
        String url = SSO_BASE_URL + SSO_USER_LOGOUT_URL;
        String token = CookieUtils.getCookieValue(request, "FILE_TOKEN");
        Map<String, String> param = new HashMap<>();
        param.put("token", token);
        String result = HttpClientUtil.doGet(url, param);
        return JsonUtils.jsonToPojo(result, Msg.class);
    }

    @Override
    public TbUser getUserByToken(String token) {
        try {
            String url = SSO_BASE_URL + SSO_GET_USER_URL;
            Map<String, String> param = new HashMap<>();
            param.put("token", token);
            String json = HttpClientUtil.doGet(url, param);

            Msg msg = Msg.formatToPojo(json, TbUser.class);
            if (msg.getStatus() == 200) {
                TbUser user = (TbUser) msg.getData();
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    @Override
    public String getSSOLoginUrl() {
        return SSO_BASE_URL;
    }
}
