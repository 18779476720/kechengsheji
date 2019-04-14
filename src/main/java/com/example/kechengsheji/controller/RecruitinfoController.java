package com.example.kechengsheji.controller;


import com.example.kechengsheji.service.RecruitinfoService;
import com.example.kechengsheji.model.Recruitinfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
* Created by chenglu on 2019-3-25.
*/
@Controller
@RequestMapping("/recruitinfo")
public class RecruitinfoController{

    @Autowired
    RecruitinfoService recruitinfoService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listRecruitinfo(){
        Recruitinfo recruitinfo=new Recruitinfo();
        return recruitinfoService.list(recruitinfo);
    }

    @RequestMapping(value="/getByIdRecruitinfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdRecruitinfo(Integer id){
        return recruitinfoService.getById(id);
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


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteRecruitinfo(@RequestBody Recruitinfo recruitinfo){
        return recruitinfoService.delete(recruitinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteRecruitinfoByIds(@RequestBody Integer[] ids){
        return recruitinfoService.deleteByIds(ids);
    }

    @RequestMapping(value = "getall",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<?> getRecruitinfo(@RequestParam("recruitinfo") String recruitinfo, @RequestParam("pageNum") Integer pageNum ,@RequestParam("pageSize") Integer pageSize){
        Recruitinfo recruitinfoVo = new Recruitinfo();
        if("".equals(recruitinfo)){
            recruitinfoVo.setRecruitType(null);
        }else{
            recruitinfoVo.setRecruitType(recruitinfo);
        }
        return recruitinfoService.getAll(recruitinfoVo,pageNum,pageSize);
    }
}
