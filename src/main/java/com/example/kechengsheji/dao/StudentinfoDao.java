package com.example.kechengsheji.dao;

import com.example.kechengsheji.model.Studentinfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
* Created by chenglu on 2019-3-9.
*/
public interface StudentinfoDao {

    int insert(Studentinfo studentinfo);

    int delete(Studentinfo studentinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Studentinfo studentinfo);

    Studentinfo getById(@Param("id") Integer id);

    List<Studentinfo> list(Studentinfo studentinfo);
}