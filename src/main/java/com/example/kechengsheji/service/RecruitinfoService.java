package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Recruitinfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* Created by chenglu on 2019-3-25.
*/
public interface RecruitinfoService {

    int insert(Recruitinfo recruitinfo);

    int delete(Recruitinfo recruitinfo);

    int deleteByIds(Integer[] ids);

    int update(Recruitinfo recruitinfo);

    Recruitinfo getById(Integer id);

    List<Recruitinfo> list(Recruitinfo recruitinfo);
    //分页参数查询
    PageInfo<Recruitinfo> getAll(Recruitinfo recruitinfo, Integer pageNum, Integer pageSize);
}