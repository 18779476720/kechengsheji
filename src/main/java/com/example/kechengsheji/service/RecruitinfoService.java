package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Recruitinfo;
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
}