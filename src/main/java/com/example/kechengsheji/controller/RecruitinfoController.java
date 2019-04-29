package com.example.kechengsheji.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.kechengsheji.dao.dto.ApiResult;
import com.example.kechengsheji.dao.enums.XKHResponseCodeEnum;
import com.example.kechengsheji.model.Account;
import com.example.kechengsheji.model.Businessinfo;
import com.example.kechengsheji.model.RecruitinfoParams;
import com.example.kechengsheji.service.AccountService;
import com.example.kechengsheji.service.BusinessinfoService;
import com.example.kechengsheji.service.RecruitinfoService;
import com.example.kechengsheji.model.Recruitinfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by chenglu on 2019-3-25.
 */
@Controller
@RequestMapping("/recruitinfo")
public class RecruitinfoController{

    @Autowired
    RecruitinfoService recruitinfoService;

    @Autowired
    BusinessinfoService businessinfoService;

    @Autowired
    AccountService accountService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listRecruitinfo(){
        Recruitinfo recruitinfo=new Recruitinfo();
        return recruitinfoService.list(recruitinfo);
    }

    //通过id查询详细
    @RequestMapping(value="/getByIdRecruitinfo",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<?> getByIdRecruitinfo(@RequestParam("id")Integer id){
        Recruitinfo recruitinfo = recruitinfoService.getById(id);
        RecruitinfoParams params = new RecruitinfoParams();
        BeanUtils.copyProperties(recruitinfo,params);
        Businessinfo businessinfo = businessinfoService.getById(recruitinfo.getBusinessId());
        String json = JSONObject.toJSON(businessinfo).toString();
        params.setBusinessinfoString(json);
        return ApiResult.buildSuccess(params);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public Object insertRecruitinfo(@RequestBody Recruitinfo recruitinfo){
        return recruitinfoService.insert(recruitinfo);
    }


    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateRecruitinfo(@RequestBody Recruitinfo recruitinfo){
        return recruitinfoService.update(recruitinfo);
    }


    //根据商家id删除某条信息
    @RequestMapping(value="/deleteRecruitinfo",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<?> deleteRecruitinfo(@RequestParam("recruitId")Integer recruitId){
        if(recruitinfoService.getById(recruitId) == null){
            return ApiResult.buildSuccess(XKHResponseCodeEnum.JOB_HAS_DELETE);
        }
        Recruitinfo recruitinfo = new Recruitinfo();
        recruitinfo.setId(recruitId);
        return ApiResult.buildSuccess(recruitinfoService.delete(recruitinfo));
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteRecruitinfoByIds(@RequestBody Integer[] ids){
        return recruitinfoService.deleteByIds(ids);
    }

    //查找所有
    @RequestMapping(value = "getall",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<?> getRecruitinfo(@RequestParam("recruitinfo") String recruitinfo, @RequestParam("pageNum") Integer pageNum , @RequestParam("pageSize") Integer pageSize, HttpSession session){
        Recruitinfo recruitinfoVo = new Recruitinfo();
        if("true".equals(recruitinfo)){
            recruitinfoVo.setRecruitType(null);
        }else{
            recruitinfoVo.setRecruitType(recruitinfo);
        }
        Object id = session.getAttribute("id");
        Account account = new Account();
        account = accountService.getById((Integer)id);
        if("2".equals(account.getRole())){
            recruitinfoVo.setUsingStatus("1");
        }
        if("1".equals(account.getRole())){
            recruitinfoVo.setUsingStatus(null);
        }
        return recruitinfoService.getAll(recruitinfoVo,pageNum,pageSize);
    }
}
