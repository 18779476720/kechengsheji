package com.example.kechengsheji.controller;

import com.example.kechengsheji.service.AnnouncementinfoService;
import com.example.kechengsheji.model.Announcementinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
* Created by chenglu on 2019-3-25.
*/
@Controller
@RequestMapping("/announcementinfo")
public class AnnouncementinfoController{

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
    public Object getByIdAnnouncementinfo(Integer id){
        return announcementinfoService.getById(id);
    }

    @RequestMapping(value="/insertAnnouncementinfo",method = RequestMethod.POST)
    @ResponseBody
    public Object insertAnnouncementinfo(@RequestBody Announcementinfo announcementinfo){
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
}
