package com.mhz.sso.service;


import com.mhz.common.utils.Msg;

public interface CheckCodeService {

    public Msg insertCheckCode(String code);

    public Msg checkCode(String token,String code);
}
