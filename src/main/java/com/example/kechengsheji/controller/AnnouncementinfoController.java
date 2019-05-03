package com.example.kechengsheji.controller;

import com.example.kechengsheji.model.Account;
import com.example.kechengsheji.service.AccountService;
import com.example.kechengsheji.service.AnnouncementinfoService;
import com.example.kechengsheji.model.Announcementinfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by chenglu on 2019-3-25.
 */
@Controller
@RequestMapping("/announcementinfo")
public class AnnouncementinfoController{

    @Autowired
    AccountService accountService;
    @Autowired
    AnnouncementinfoService announcementinfoService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listAnnouncementinfo(){
        Announcementinfo announcementinfo=new Announcementinfo();
        return announcementinfoService.list(announcementinfo);
    }

    @RequestMapping(value="/getByIdAnnouncementinfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdAnnouncementinfo(@RequestParam("id")Integer id){
        return announcementinfoService.getById(id);
    }

    @RequestMapping(value="/insertAnnouncementinfo",method = RequestMethod.POST)
    @ResponseBody
    public Object insertAnnouncementinfo(@RequestBody Announcementinfo announcementinfo,HttpSession session){
        Object id = session.getAttribute("id");
        Account account = accountService.getById((Integer) id);
        announcementinfo.setCreatedBy(account.getAccountname());
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());
        String format1 = "yyyy-MM-dd";
        try {
            date = new SimpleDateFormat(format1).parse(String.valueOf(timeStamep));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        announcementinfo.setCreateDate(date);
        return announcementinfoService.insert(announcementinfo);
    }


    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateAnnouncementinfo(@RequestBody Announcementinfo announcementinfo){
        return announcementinfoService.update(announcementinfo);
    }


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteAnnouncementinfo(@RequestBody Announcementinfo announcementinfo){
        return announcementinfoService.delete(announcementinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteAnnouncementinfoByIds(@RequestBody Integer[] ids){
        return announcementinfoService.deleteByIds(ids);
    }

    //查询所有公告  flag=true是查询所有公告，flag=false时，是查询当前登录人发布的公告
    @RequestMapping(value = "getall",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<?> getRecruitinfo(@RequestParam("flag")Boolean flag, @RequestParam("pageNum") Integer pageNum , @RequestParam("pageSize") Integer pageSize, HttpSession httpSession){
        Object id = null;
        if(flag == false){
            id = httpSession.getAttribute("id");
        }else{
            id = null;
        }
        return announcementinfoService.getAll((Integer) id,pageNum,pageSize);
    }
}
