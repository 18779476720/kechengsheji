package com.example.kechengsheji.dao;

import com.example.kechengsheji.model.Businessinfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
* Created by chenglu on 2019-3-25.
*/
@Mapper
@Component(value="BusinessinfoDao")
public interface BusinessinfoDao {

    int insert(Businessinfo businessinfo);

    int delete(Businessinfo businessinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Businessinfo businessinfo);

    Businessinfo getById(@Param("id") Integer id);

    //通过用户名修改商家信息
    Businessinfo updateBusinessInfoByAccountName(Businessinfo businessinfo);

    List<Businessinfo> list(Businessinfo businessinfo);
}