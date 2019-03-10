package com.example.kechengsheji.controller;


import com.example.kechengsheji.service.SchoolinfoService;
import com.example.kechengsheji.model.Schoolinfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
* Created by chenglu on 2019-3-9.
*/
@Controller
@RequestMapping("/schoolinfo")
public class SchoolinfoController{

    @Autowired
    SchoolinfoService schoolinfoService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listSchoolinfo(){
        Schoolinfo schoolinfo=new Schoolinfo();
        return schoolinfoService.list(schoolinfo);
    }

    @RequestMapping(value="getById.ztc",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdSchoolinfo(Integer id){
        return schoolinfoService.getById(id);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public Object insertSchoolinfo(@RequestBody Schoolinfo schoolinfo){
        return schoolinfoService.insert(schoolinfo);
    }


    @RequestMapping(value="",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateSchoolinfo(@RequestBody Schoolinfo schoolinfo){
        return schoolinfoService.update(schoolinfo);
    }


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteSchoolinfo(@RequestBody Schoolinfo schoolinfo){
        return schoolinfoService.delete(schoolinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteSchoolinfoByIds(@RequestBody Integer[] ids){
        return schoolinfoService.deleteByIds(ids);
    }
}
