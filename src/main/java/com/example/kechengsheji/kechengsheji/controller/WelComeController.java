package com.example.kechengsheji.kechengsheji.controller;
/**
* @Description:    controller入口类，进入登录界面
* @Author:          longhua.wang
* @CreateDate:     2019/2/23 16:36
* @UpdateUser:     longhua.wang
* @UpdateDate:     2019/2/23 16:36
*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("welcome")
public class WelComeController {

    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("welcome")
    @ResponseBody
    public String getMovie(){
        return "哈哈哈";
    }
}
