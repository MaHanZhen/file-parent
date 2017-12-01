package com.mhz.select.service;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.utils.Msg;

public interface UserService {

    public EasyUIDataGridResult getUserList(Integer page, Integer rows);

}
