package com.example.kechengsheji.controller;

import com.example.kechengsheji.dao.emailTool.SendEmailTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/send")
@Controller
public class ManagerController {
    @Autowired
    @Qualifier("sendByEmail")
    private SendEmailTool service;

    @RequestMapping("/send")
    @ResponseBody
    public String send(){

        String sender="1252490060@qq.com";   //这个是发送人的邮箱
        String receiver="17679119457@163.com";  //这个是接受人的邮箱
        String title="草拟吗";    //标题
        String text="逼崽子";

        String result=service.send(sender, receiver, title, text);
        return result;
    }
}
