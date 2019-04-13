package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Businessinfo;
import java.util.List;

/**
* Created by chenglu on 2019-3-25.
*/
public interface BusinessinfoService {

    int insert(Businessinfo businessinfo);

    int delete(Businessinfo businessinfo);

    int deleteByIds(Integer[] ids);

    int update(Businessinfo businessinfo);

    Businessinfo getById(Integer id);

    List<Businessinfo> list(Businessinfo businessinfo);
}