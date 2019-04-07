package com.example.kechengsheji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @Description:    此controller专门作为跳转页面
* @Author:          longhua.wang
* @CreateDate:     2019/3/24 18:02
* @UpdateUser:     longhua.wang
* @UpdateDate:     2019/3/24 18:02
*/
@Controller
@RequestMapping("/public")
public class JumpController {
    /**
     * 跳转页面的通用方法
     * @param html_url 跳转页面的页面路径名称
     * @return
     */
    @RequestMapping("/util/jump")
    public String publicJump(@RequestParam("html_url") String html_url){
        return html_url;
    }
}
