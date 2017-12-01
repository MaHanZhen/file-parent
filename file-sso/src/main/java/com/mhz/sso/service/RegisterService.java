package com.mhz.sso.service;

import com.mhz.common.pojo.TbUser;
import com.mhz.common.utils.Msg;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    public Msg doRegister(TbUser user);
}
