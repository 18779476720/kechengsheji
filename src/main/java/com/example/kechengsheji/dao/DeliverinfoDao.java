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

    //查询投递信息表中当前用户要投递的信息的已招聘数量
    int selectHasDelivery(@Param("recruitId")Integer recruitId);

    //查询该用户是否已经投递该职位
    int selectIsHasDelivery(@Param("accountId")Integer accountId,@Param("recruitId")Integer recruitId);
}