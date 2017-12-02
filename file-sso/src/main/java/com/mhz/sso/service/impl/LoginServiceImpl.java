package com.mhz.sso.service.impl;

import com.mhz.common.mapper.TbUserMapper;
import com.mhz.common.pojo.TbUser;
import com.mhz.common.pojo.TbUserExample;
import com.mhz.common.utils.CookieUtils;
import com.mhz.common.utils.JsonUtils;
import com.mhz.common.utils.Msg;
import com.mhz.sso.dao.JedisClient;
import com.mhz.sso.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private TbUserMapper userMapper;

    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;
    @Value("${SSO_SESSION_EXPIRE}")
    private Integer SSO_SESSION_EXPIRE;

    @Override
    public Msg doLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {

        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusNotEqualTo((byte) 0);

        List<TbUser> tbUsers = userMapper.selectByExample(example);
        if (tbUsers == null || tbUsers.size() == 0) {
            return Msg.build(400, "该用户不存在");
        }

        TbUser user = tbUsers.get(0);
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return Msg.build(400, "用户名或密码错误");
        }

        user.setPassword(null);

        String token = UUID.randomUUID().toString();
        String key = REDIS_USER_SESSION_KEY + ":" + token;
        jedisClient.set(key, JsonUtils.objectToJson(user));
        jedisClient.expire(key, SSO_SESSION_EXPIRE);
        CookieUtils.setCookie(request, response, "FILE_TOKEN", token);

        return Msg.ok(token);
    }

    @Override
    public Msg getUserByToken(String token) {
        String key = REDIS_USER_SESSION_KEY + ":" + token;

        String jsonUser = jedisClient.get(key);
        if (StringUtils.isEmpty(jsonUser)) {
            return Msg.build(400, "此session已经过期，请重新登录");
        }
        jedisClient.expire(key, SSO_SESSION_EXPIRE);
        TbUser user = JsonUtils.jsonToPojo(jsonUser,TbUser.class);

        return Msg.ok(user);
    }
}
