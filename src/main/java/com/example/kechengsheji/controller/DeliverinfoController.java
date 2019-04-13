package com.example.kechengsheji.controller;


import com.example.kechengsheji.service.DeliverinfoService;
import com.example.kechengsheji.model.Deliverinfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
* Created by chenglu on 2019-3-25.
*/
@Controller
@RequestMapping("/deliverinfo")
public class DeliverinfoController{

    @Autowired
    DeliverinfoService deliverinfoService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listDeliverinfo(){
        Deliverinfo deliverinfo=new Deliverinfo();
        return deliverinfoService.list(deliverinfo);
    }

    @RequestMapping(value="/getByIdBusinessinfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdBusinessinfo(Integer id){
        return deliverinfoService.getById(id);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public Object insertDeliverinfo(@RequestBody Deliverinfo deliverinfo){
        return deliverinfoService.insert(deliverinfo);
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
}
