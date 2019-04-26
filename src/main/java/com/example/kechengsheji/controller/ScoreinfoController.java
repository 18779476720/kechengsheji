package com.example.kechengsheji.controller;


import com.example.kechengsheji.dao.dto.ApiResult;
import com.example.kechengsheji.service.ScoreinfoService;
import com.example.kechengsheji.model.Scoreinfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by chenglu on 2019-3-25.
 */
@Controller
@RequestMapping("/scoreinfo")
public class ScoreinfoController{

    @Autowired
    ScoreinfoService scoreinfoService;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public Object listScoreinfo(){
        Scoreinfo scoreinfo=new Scoreinfo();
        return scoreinfoService.list(scoreinfo);
    }

    @RequestMapping(value="/getByIdScoreinfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getByIdScoreinfo(Integer id){
        return scoreinfoService.getById(id);
    }

    @RequestMapping(value="saveScore",method = RequestMethod.POST)
    @ResponseBody
    public Object insertScoreinfo(@RequestBody Scoreinfo scoreinfo){
        return scoreinfoService.insert(scoreinfo);
    }


    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateScoreinfo(@RequestBody Scoreinfo scoreinfo){
        return scoreinfoService.update(scoreinfo);
    }


    @RequestMapping(value="/selective",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteScoreinfo(@RequestBody Scoreinfo scoreinfo){
        return scoreinfoService.delete(scoreinfo);
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteScoreinfoByIds(@RequestBody Integer[] ids){
        return scoreinfoService.deleteByIds(ids);
    }

    @RequestMapping(value="/getMyScoreinfo",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<?> getMyScoreinfo(@RequestParam("pageNum") Integer pageNum , @RequestParam("pageSize") Integer pageSize, HttpSession httpSession){
        Scoreinfo scoreinfo = new Scoreinfo();
        scoreinfo.setAccountId((Integer) httpSession.getAttribute("id"));
        return ApiResult.buildSuccess(scoreinfoService.getAll(scoreinfo,pageNum,pageSize));
    }
}
