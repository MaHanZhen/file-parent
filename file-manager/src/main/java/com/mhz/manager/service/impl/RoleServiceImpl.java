package com.mhz.manager.service.impl;

import com.mhz.common.mapper.TbRoleMapper;
import com.mhz.common.pojo.TbRole;
import com.mhz.common.pojo.TbRoleExample;
import com.mhz.common.utils.HttpClientUtil;
import com.mhz.common.utils.JsonUtils;
import com.mhz.manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private TbRoleMapper roleMapper;
    @Value("${SELECT_BASE_URL}")
    private String SELECT_BASE_URL;
    @Value("${SELECT_ROLE_LIST}")
    private String SELECT_ROLE_LIST;


    @Override
    public List<TbRole> getRoleList(Integer id) {

        String url = SELECT_BASE_URL +SELECT_ROLE_LIST;

        Map<String, String> param = new HashMap<>();
        if(id!=null) {
            param.put("id",id.toString());
        }
        String result = HttpClientUtil.doPost(url,param);
        if(!StringUtils.isEmpty(result)){
            List<TbRole> roles = JsonUtils.jsonToList(result,TbRole.class);
            return roles;
        }
        return null;
    }
}
