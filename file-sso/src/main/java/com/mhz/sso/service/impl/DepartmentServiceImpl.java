package com.mhz.sso.service.impl;

import com.mhz.common.pojo.TbDepartment;
import com.mhz.common.utils.HttpClientUtil;
import com.mhz.common.utils.JsonUtils;
import com.mhz.common.utils.Msg;
import com.mhz.sso.service.DepartmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Value("${SELECT_BASE_URL}")
    private String SELECT_BASE_URL;

    @Value("${SELECT_DEPARTMENT_INPUT_LIST}")
    private String SELECT_DEPARTMENT_INPUT_LIST;

    @Override
    public Msg getDepartmentList() {
        String url = SELECT_BASE_URL + SELECT_DEPARTMENT_INPUT_LIST;
        String result = HttpClientUtil.doGet(url);
        if (!StringUtils.isEmpty(result)) {
            List<TbDepartment> tbDepartments = JsonUtils.jsonToList(result, TbDepartment.class);
            return Msg.ok(tbDepartments);
        }
        return Msg.build(400, null);

    }
}
