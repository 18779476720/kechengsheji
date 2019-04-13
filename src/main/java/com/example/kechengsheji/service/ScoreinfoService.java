package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Scoreinfo;
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
}