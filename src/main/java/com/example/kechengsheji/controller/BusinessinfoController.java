package com.example.kechengsheji.controller;


import com.example.kechengsheji.model.Recruitinfo;
import com.example.kechengsheji.service.AccountService;
import com.example.kechengsheji.service.BusinessinfoService;
import com.example.kechengsheji.model.Businessinfo;
import java.util.List;

import com.example.kechengsheji.service.RecruitinfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by chenglu on 2019-3-25.
 */
@Controller
@RequestMapping("/businessinfo")
public class BusinessinfoController{

    @Autowired
    BusinessinfoService businessinfoService;

    @Autowired
    RecruitinfoService recruitinfoService;

    @Autowired
    AccountService accountService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listBusinessinfo(){
        Businessinfo businessinfo=new Businessinfo();
        return businessinfoService.list(businessinfo);
    }

    @RequestMapping(value="/getByIdBusinessinfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdBusinessinfo(@RequestParam("id")Integer id){
        return businessinfoService.getById(id);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public Object insertBusinessinfo(@RequestBody Businessinfo businessinfo){
        return businessinfoService.insert(businessinfo);
    }


    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateBusinessinfo(@RequestBody Businessinfo businessinfo){
        return businessinfoService.update(businessinfo);
    }


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteBusinessinfo(@RequestBody Businessinfo businessinfo){
        return businessinfoService.delete(businessinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteBusinessinfoByIds(@RequestBody Integer[] ids){
        return businessinfoService.deleteByIds(ids);
    }

    //查找所有
    @RequestMapping(value = "businessGetByBusinessId",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<?> getListBusinessInfo(@RequestParam("pageNum") Integer pageNum , @RequestParam("pageSize") Integer pageSize, HttpSession session){
        Recruitinfo recruitinfoVo = new Recruitinfo();
        Object id = session.getAttribute("id");
        String accountName = accountService.getById((Integer)id).getAccountname();
        Businessinfo businessinVo = new Businessinfo();
        businessinVo = businessinfoService.getByAccountName(accountName);
        recruitinfoVo.setBusinessId(businessinVo.getId());
        recruitinfoVo.setRecruitType(null);
        return recruitinfoService.getAll(recruitinfoVo,pageNum,pageSize);
    }
}
