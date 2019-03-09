package com.example.kechengsheji.kechengsheji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 登录的controller
 * @Author: longhua.wang
 * @CreateDate: 2019/3/5 23:19
 * @UpdateUser: longhua.wang
 * @UpdateDate: 2019/3/5 23:19
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    //登录方法
    @RequestMapping("/addlogin")
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("123") && password.equals("456")) {
           return "studentHomePage";
        } else {
            return "index";
        }
    }
}
