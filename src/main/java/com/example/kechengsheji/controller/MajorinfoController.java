package com.example.kechengsheji.controller;
import com.example.kechengsheji.service.MajorinfoService;
import com.example.kechengsheji.model.Majorinfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
* Created by chenglu on 2019-3-9.
*/
@Controller
@RequestMapping("/majorinfo")
public class MajorinfoController{

    @Autowired
    MajorinfoService majorinfoService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listMajorinfo(){
        Majorinfo majorinfo=new Majorinfo();
        return majorinfoService.list(majorinfo);
    }

    @RequestMapping(value="getById.ztc",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdMajorinfo(Integer id){
        return majorinfoService.getById(id);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public Object insertMajorinfo(@RequestBody Majorinfo majorinfo){
        return majorinfoService.insert(majorinfo);
    }


    @RequestMapping(value="",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateMajorinfo(@RequestBody Majorinfo majorinfo){
        return majorinfoService.update(majorinfo);
    }


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteMajorinfo(@RequestBody Majorinfo majorinfo){
        return majorinfoService.delete(majorinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteMajorinfoByIds(@RequestBody Integer[] ids){
        return majorinfoService.deleteByIds(ids);
    }
}
