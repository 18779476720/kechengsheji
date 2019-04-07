package com.example.kechengsheji.dao;

import com.example.kechengsheji.model.Studentinfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
* Created by chenglu on 2019-3-9.
*/
@Mapper
@Component(value = "StudentinfoDao")
public interface StudentinfoDao {

    int insert(Studentinfo studentinfo);

    int delete(Studentinfo studentinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Studentinfo studentinfo);

    Studentinfo getById(@Param("id") Integer id);

    Studentinfo getByName(@Param("accountname") String accountname);

    Studentinfo updateByAccountName(Studentinfo studentinfo);

    List<Studentinfo> list(Studentinfo studentinfo);
}