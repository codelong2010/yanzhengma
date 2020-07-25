package com.yanzhengma.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import com.yanzhengma.pojo.JsonData;
import com.yanzhengma.pojo.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author xiaolong
 * @create 2020-07-24 22:22
 * @description
 */
@Controller
public class LoginController {


    @RequestMapping("/login")
    public Object Login(){
        return "login";
    }

    @RequestMapping("/login/captcha")
    public void LoginCaptcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(135, 50);
        lineCaptcha.createCode();
        System.out.println(lineCaptcha.getCode());
        HttpSession session=request.getSession();
        session.setAttribute("captcha",lineCaptcha.getCode());
        ICaptcha captcha = lineCaptcha;
        captcha.write(response.getOutputStream());
    }

    @RequestMapping("/login/sumbit")
    @ResponseBody
    public Object LoginSumbit(@RequestBody Login login, HttpServletRequest request){
        //模拟数据库账号密码
        Map<String,Object> loginmap=new HashMap<>();
        loginmap.put("username","zhangsan");
        loginmap.put("password","123456");

        HttpSession session=request.getSession();
        String str=(String)session.getAttribute("captcha");
        System.out.println(str);
        if(str.equals(login.getCaptcha())){
            if(login.getUsername().equals(loginmap.get("username"))){
                if(login.getPassword().equals(loginmap.get("password"))){
                    return new JsonData(0,"登录成功",null);
                }
                else {
                   return new JsonData(-3,"密码错误",null);
                }
            }
            else {
                return new JsonData(-2,"账号不存在",null);
            }
        }
        else {
            return new JsonData(-1,"验证码错误",null);
        }
    }
}
