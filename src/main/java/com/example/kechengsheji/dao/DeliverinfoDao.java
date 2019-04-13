package com.example.kechengsheji.dao;

import com.example.kechengsheji.model.Deliverinfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
* Created by chenglu on 2019-3-25.
*/
@Mapper
@Component(value = "DeliverinfoDao")
public interface DeliverinfoDao {

    int insert(Deliverinfo deliverinfo);

    int delete(Deliverinfo deliverinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Deliverinfo deliverinfo);

    Deliverinfo getById(@Param("id") Integer id);

    List<Deliverinfo> list(Deliverinfo deliverinfo);
}