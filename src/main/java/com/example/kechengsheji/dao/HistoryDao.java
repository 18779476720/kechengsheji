package com.example.kechengsheji.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.kechengsheji.model.History;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "HistoryDao")
public interface HistoryDao {
    int insert(History history);

    int delete(History history);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(History history);

    History getById(@Param("id") Integer id);

    List<History> list(History history);
}
