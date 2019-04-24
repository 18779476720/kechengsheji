package com.example.kechengsheji.controller;


import com.example.kechengsheji.service.BusinessinfoService;
import com.example.kechengsheji.model.Businessinfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by chenglu on 2019-3-25.
 */
@Controller
@RequestMapping("/businessinfo")
public class BusinessinfoController{

    @Autowired
    BusinessinfoService businessinfoService;

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
}
