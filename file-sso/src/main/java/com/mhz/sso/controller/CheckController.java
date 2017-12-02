package com.mhz.sso.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.mhz.common.utils.Msg;
import com.mhz.sso.pojo.BootstrapValidatorRemote;
import com.mhz.sso.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private Producer captchaProducer;

    @Autowired
    private CheckService checkService;

    @RequestMapping("/getCheckCode")
    public Msg getCheckCodeImage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = captchaProducer.createText();

        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

    @RequestMapping("/code")
    @ResponseBody
    public Msg check() {
        return null;
    }

    @RequestMapping("/data/{type}")
    @ResponseBody
    public BootstrapValidatorRemote checkData(@PathVariable() Integer type, String username, String email) {
        return checkService.checkData(type, username, email);
    }
}
