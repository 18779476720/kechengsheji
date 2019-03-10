package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Majorinfo;
import java.util.List;

/**
* Created by chenglu on 2019-3-9.
*/
public interface MajorinfoService {

    int insert(Majorinfo majorinfo);

    int delete(Majorinfo majorinfo);

    int deleteByIds(Integer[] ids);

    int update(Majorinfo majorinfo);

    Majorinfo getById(Integer id);

    List<Majorinfo> list(Majorinfo majorinfo);
}