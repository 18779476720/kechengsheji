package com.example.kechengsheji.dao;

import com.example.kechengsheji.model.Recruitinfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by chenglu on 2019-3-25.
 */
@Mapper
@Component(value="RecruitinfoDao")
public interface RecruitinfoDao {

    int insert(Recruitinfo recruitinfo);

    int delete(Recruitinfo recruitinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Recruitinfo recruitinfo);

    Recruitinfo getById(@Param("id") Integer id);

    List<Recruitinfo> list(Recruitinfo recruitinfo);

}