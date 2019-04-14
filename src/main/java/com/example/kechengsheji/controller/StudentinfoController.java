package com.example.kechengsheji.controller;


import com.example.kechengsheji.service.StudentinfoService;
import com.example.kechengsheji.model.Studentinfo;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
* Created by chenglu on 2019-3-9.
*/
@Controller
@RequestMapping("/studentinfo")
public class StudentinfoController{

    @Autowired
    StudentinfoService studentinfoService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listStudentinfo(){
        Studentinfo studentinfo=new Studentinfo();
        return studentinfoService.list(studentinfo);
    }

    @RequestMapping(value="getById.ztc",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdStudentinfo(Integer id){
        return studentinfoService.getById(id);
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public Object insertStudentinfo(@RequestBody Studentinfo studentinfo){
        return studentinfoService.insert(studentinfo);
    }


    @RequestMapping(value="",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateStudentinfo(@RequestBody Studentinfo studentinfo){
        return studentinfoService.update(studentinfo);
    }


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStudentinfo(@RequestBody Studentinfo studentinfo){
        return studentinfoService.delete(studentinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStudentinfoByIds(@RequestBody Integer[] ids){
        return studentinfoService.deleteByIds(ids);
    }
    @RequestMapping(value = "getall")
    @ResponseBody
    public PageInfo<?> getStudentInfo(@RequestBody Studentinfo studentinfo, @RequestParam("pageNum") Integer pageNum ,@RequestParam("pageSize") Integer pageSize){
        return studentinfoService.getAll(studentinfo,pageNum,pageSize);
    }
}
