package com.mhz.manager.service;

import com.mhz.common.pojo.EasyUIDataGridResult;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.utils.Msg;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    public EasyUIDataGridResult getUserList(Integer page,Integer rows);

    public Msg updateUser(TbUser user);

    public Msg removeUser(int id);

    public Msg doLogout(HttpServletRequest request);

    public TbUser getUserByToken(String token);

    public String getSSOLoginUrl();

}
