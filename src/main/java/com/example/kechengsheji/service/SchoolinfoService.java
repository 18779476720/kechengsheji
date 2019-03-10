package com.example.kechengsheji.service;
import com.example.kechengsheji.model.Schoolinfo;
import java.util.List;

/**
* Created by chenglu on 2019-3-9.
*/
public interface SchoolinfoService {

    int insert(Schoolinfo schoolinfo);

    int delete(Schoolinfo schoolinfo);

    int deleteByIds(Integer[] ids);

    int update(Schoolinfo schoolinfo);

    Schoolinfo getById(Integer id);

    List<Schoolinfo> list(Schoolinfo schoolinfo);
}