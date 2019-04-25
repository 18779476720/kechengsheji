package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Deliverinfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by chenglu on 2019-3-25.
 */
public interface DeliverinfoService {

    int insert(Deliverinfo deliverinfo);

    int delete(Deliverinfo deliverinfo);

    int deleteByIds(Integer[] ids);

    int update(Deliverinfo deliverinfo);

    Deliverinfo getById(Integer id);

    List<Deliverinfo> list(Deliverinfo deliverinfo,Integer pageNum,Integer pageSize);

    //分页参数查询
    PageInfo<Deliverinfo> getAll(Deliverinfo recruitinfo, Integer pageNum, Integer pageSize);
}