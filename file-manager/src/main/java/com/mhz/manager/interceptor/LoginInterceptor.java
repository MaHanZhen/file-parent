package com.mhz.manager.interceptor;

import com.mhz.common.pojo.TbUser;
import com.mhz.common.utils.CookieUtils;
import com.mhz.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = CookieUtils.getCookieValue(request, "FILE_TOKEN");
        //根据token换取用户信息，调用sso系统的接口。
        TbUser user = userService.getUserByToken(token);
        //取不到用户信息
        if (null == user || user.getrId() != 1) {
            //跳转到登录页面，把用户请求的url作为参数传递给登录页面。
            response.setCharacterEncoding("UTF-8");
            response.sendRedirect(userService.getSSOLoginUrl()
                    + "?error=yes&redirect=" + request.getRequestURL());
            //返回false
            return false;
        }
        //取到用户信息，放行
        //返回值决定handler是否执行。true：执行，false：不执行。
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
