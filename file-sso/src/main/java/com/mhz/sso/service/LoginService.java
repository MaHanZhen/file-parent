package com.mhz.sso.service;

import com.mhz.common.utils.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    public Msg doLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);

    public Msg getUserByToken(String token);
}
