package com.example.kechengsheji.service;
import com.example.kechengsheji.model.Account;
import com.example.kechengsheji.model.Studentinfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* Created by chenglu on 2019-3-9.
*/
public interface StudentinfoService {


    int insert(Studentinfo studentinfo);

    int delete(Studentinfo studentinfo);

    int deleteByIds(Integer[] ids);

    int update(Studentinfo studentinfo);

    Studentinfo getById(Integer id);

    Studentinfo getByName(String accountname);

    Studentinfo updateByAccountName(Studentinfo studentinfo);

    List<Studentinfo> list(Studentinfo studentinfo);

    PageInfo<Studentinfo> getAll(Studentinfo studentinfo, Integer pageNum, Integer pageSize);
}