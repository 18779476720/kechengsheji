package com.example.kechengsheji.controller;


import com.example.kechengsheji.dao.dto.ApiResult;
import com.example.kechengsheji.dao.enums.XKHResponseCodeEnum;
import com.example.kechengsheji.service.DeliverinfoService;
import com.example.kechengsheji.model.Deliverinfo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.kechengsheji.service.RecruitinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by chenglu on 2019-3-25.
 */
@Controller
@RequestMapping("/deliverinfo")
public class DeliverinfoController{

    @Autowired
    DeliverinfoService deliverinfoService;

    @Autowired
    RecruitinfoService recruitinfoService;
    @RequestMapping(value="/getByIdBusinessinfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdBusinessinfo(Integer id){
        return deliverinfoService.getById(id);
    }

    @RequestMapping(value="insertDeliverinfo",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<?> insertDeliverinfo(@RequestBody Deliverinfo deliverinfo,HttpSession session){
        //该职位已通过人数
        int hasOffer = deliverinfoService.selectHasDelivery(deliverinfo.getRecruitId());
        //查询该招聘信息招聘人数
        int needNum = recruitinfoService.getById(deliverinfo.getRecruitId()).getRecruitNum();
        //该职位已招满
        if(hasOffer >= needNum){
            return ApiResult.build(XKHResponseCodeEnum.JOB_HAS_DONE);
        }
        //已经投递该职位
        int hasdelivery = deliverinfoService.selectIsHasDelivery((Integer) session.getAttribute("id"),deliverinfo.getRecruitId());
        if(hasdelivery > 0){
            return ApiResult.build(XKHResponseCodeEnum.HAS_DELIVERY);
        }
        Deliverinfo deliverinfoVo = new Deliverinfo();
        deliverinfoVo.setAccountId((Integer) session.getAttribute("id"));
        deliverinfoVo.setDeliverStatus("已投递");
        deliverinfoVo.setRecruitId(deliverinfo.getRecruitId());
        //投递日期取当前时间
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());
        String format1 = "yyyy-MM-dd";
        try {
            date = new SimpleDateFormat(format1).parse(String.valueOf(timeStamep));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        deliverinfoVo.setCreateDate(date);
        return ApiResult.buildSuccess(deliverinfoService.insert(deliverinfoVo));
    }


    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateDeliverinfo(@RequestBody Deliverinfo deliverinfo){
        return deliverinfoService.update(deliverinfo);
    }


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteDeliverinfo(@RequestBody Deliverinfo deliverinfo){
        return deliverinfoService.delete(deliverinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteDeliverinfoByIds(@RequestBody Integer[] ids){
        return deliverinfoService.deleteByIds(ids);
    }

    @RequestMapping(value="/getMyDeliverinfo",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<?> getMyDeliverinfo(@RequestParam("pageNum") Integer pageNum ,@RequestParam("pageSize") Integer pageSize,HttpSession httpSession){
        Deliverinfo deliverinfo = new Deliverinfo();
        deliverinfo.setAccountId((Integer) httpSession.getAttribute("id"));
        return ApiResult.buildSuccess(deliverinfoService.getAll(deliverinfo,pageNum,pageSize));
    }
}
