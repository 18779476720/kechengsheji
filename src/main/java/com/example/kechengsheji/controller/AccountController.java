package com.example.kechengsheji.controller;
import com.example.kechengsheji.dao.dto.ApiResult;
import com.example.kechengsheji.dao.enums.XKHResponseCodeEnum;
import com.example.kechengsheji.model.AccountParams;
import com.example.kechengsheji.service.AccountService;
import com.example.kechengsheji.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpSession;
/**
* Created by chenglu on 2019-3-9.
*/
@Controller
@RequestMapping("/account")
public class AccountController{

    @Autowired
    AccountService accountService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    private Object listAccount(){
        Account account=new Account();
        return accountService.list(account);
    }
    //用户登录
    @RequestMapping(value = "/login")
    @ResponseBody
    public ApiResult<?> login(@RequestBody Account account, HttpSession httpSession) {
        ApiResult<?> apiResult = null;
        String name = account.getAccountname();
        String password = account.getPassword();
        account = accountService.getByAccountname(account.getAccountname());
        if(account == null){
            //该用户不存在
            return  ApiResult.build(XKHResponseCodeEnum.NOUSER);
        }
        if ("" != account.getPassword() && !account.getPassword().equals(password)) {
            //密码错误
            return  ApiResult.build(XKHResponseCodeEnum.PASS_ERROR);
        }
        httpSession.setAttribute("id", account.getId());
        return ApiResult.buildSuccess(account);
    }
    //用户注册
    @RequestMapping(value = "/registerIn", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<?> register(@RequestBody AccountParams params) {
        //查询该用户名是否存在
        int num = accountService.selectCount(params.getAccountname());
        if(num > 0){
            return ApiResult.build(XKHResponseCodeEnum.ACCOUNT_HAS);
        }
        return ApiResult.buildSuccess(accountService.saveOrUpdateAccount(params));
    }


    @RequestMapping("/register")
    public String Index() {
        return "register";
    }


    @RequestMapping(value="getById.ztc",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdAccount(Integer id){
        return accountService.getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateAccount(@RequestBody Account account) {
        return accountService.update(account);
    }

    @RequestMapping(value = "/selective", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteAccount(@RequestBody Account account) {
        return accountService.delete(account);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteAccountByIds(@RequestBody Integer[] ids) {
        return accountService.deleteByIds(ids);
    }

    // 判断账号是否已经注册
    @RequestMapping(value = "/checkname")
    @ResponseBody
    public Object checkName(@RequestParam("accountname") String name) {
        return accountService.selectCount(name);

    }

    /**
     * 加载静态资源
     */
    @Configuration
    public class UsingStaticController extends WebMvcConfigurationSupport {

        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }
}
