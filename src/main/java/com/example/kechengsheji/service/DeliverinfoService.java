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

    //查询投递信息表中当前用户要投递的信息的已招聘数量
    int selectHasDelivery(Integer recruitId);

    //查询该用户是否已经投递该职位
    int selectIsHasDelivery(Integer accountId,Integer recruitId);
}