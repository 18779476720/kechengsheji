package com.example.kechengsheji.dao;

import com.example.kechengsheji.model.Scoreinfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
* Created by chenglu on 2019-3-25.
*/
@Mapper
@Component(value="ScoreinfoDao")
public interface ScoreinfoDao {

    int insert(Scoreinfo scoreinfo);

    int delete(Scoreinfo scoreinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Scoreinfo scoreinfo);

    Scoreinfo getById(@Param("id") Integer id);

    List<Scoreinfo> list(Scoreinfo scoreinfo);

    List<Scoreinfo> list1(Scoreinfo scoreinfo);
}