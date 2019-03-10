package com.example.kechengsheji.controller;
import com.example.kechengsheji.service.AccountService;
import com.example.kechengsheji.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/login")
    @ResponseBody
    public Object listUser(@RequestBody Account account, HttpSession httpSession) {
        Object object = null;
        String name = account.getAccountname();
        String password = account.getPassword();
        if (name != null && !name.equals("")) {
            account = accountService.getByAccountname(account.getAccountname());
            System.out.print(account);
        }
        if (account.getPassword() != null && account.getPassword().equals(password)) {
            httpSession.setAttribute("id", account.getId());
            object =  (Object)account;
        }
        return object;
    }
    @RequestMapping("/login/success")
    public String LoginSuccess(){
        return "ok";
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


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object insertAccount(@RequestBody Account account) {
        if (accountService.selectCount(account.getAccountname()) == 0) {
            return accountService.insert(account);
        }
        return "用户已经被注册";
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
}
