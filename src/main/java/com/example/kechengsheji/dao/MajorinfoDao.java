package com.example.kechengsheji.dao;

import com.example.kechengsheji.model.Majorinfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
* Created by chenglu on 2019-3-9.
*/
public interface MajorinfoDao {

    int insert(Majorinfo majorinfo);

    int delete(Majorinfo majorinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Majorinfo majorinfo);

    Majorinfo getById(@Param("id") Integer id);

    List<Majorinfo> list(Majorinfo majorinfo);
}