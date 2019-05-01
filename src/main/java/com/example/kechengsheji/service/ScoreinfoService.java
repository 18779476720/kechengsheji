package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Scoreinfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by chenglu on 2019-3-25.
 */
public interface ScoreinfoService {

    int insert(Scoreinfo scoreinfo);

    int delete(Scoreinfo scoreinfo);

    int deleteByIds(Integer[] ids);

    int update(Scoreinfo scoreinfo);

    Scoreinfo getById(Integer id);

    List<Scoreinfo> list(Scoreinfo scoreinfo);
    List<Scoreinfo> list1(Scoreinfo scoreinfo);

    //分页参数查询
    PageInfo<Scoreinfo> getAll(Scoreinfo recruitinfo, Integer pageNum, Integer pageSize);
}