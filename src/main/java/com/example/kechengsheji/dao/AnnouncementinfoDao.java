package com.example.kechengsheji.dao;
import org.apache.ibatis.annotations.Mapper;
import com.example.kechengsheji.model.Announcementinfo;
import java.util.List;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Param;

/**
* Created by chenglu on 2019-3-25.
*/
@Mapper
@Component(value = "AnnouncementinfoDao")
public interface AnnouncementinfoDao {

    int insert(Announcementinfo announcementinfo);

    int delete(Announcementinfo announcementinfo);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Announcementinfo announcementinfo);

    Announcementinfo getById(@Param("id") Integer id);

    List<Announcementinfo> list(Announcementinfo announcementinfo);
}