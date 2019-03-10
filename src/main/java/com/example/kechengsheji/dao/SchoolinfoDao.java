package com.example.kechengsheji.dao;

import com.example.kechengsheji.model.Schoolinfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
* Created by chenglu on 2019-3-9.
*/
public interface SchoolinfoDao {

    int insert(Schoolinfo schoolinfo);

    int delete(Schoolinfo schoolinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Schoolinfo schoolinfo);

    Schoolinfo getById(@Param("id") Integer id);

    List<Schoolinfo> list(Schoolinfo schoolinfo);
}