package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Announcementinfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by chenglu on 2019-3-25.
 */
public interface AnnouncementinfoService {

    int insert(Announcementinfo announcementinfo);

    int delete(Announcementinfo announcementinfo);

    int deleteByIds(Integer[] ids);

    int update(Announcementinfo announcementinfo);

    Announcementinfo getById(Integer id);

    List<Announcementinfo> list(Announcementinfo announcementinfo);
    //分页参数查询
    PageInfo<Announcementinfo> getAll(Integer id,Integer pageNum, Integer pageSize);

}