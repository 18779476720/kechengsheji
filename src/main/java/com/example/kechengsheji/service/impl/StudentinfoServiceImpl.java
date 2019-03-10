package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.StudentinfoService;
import com.example.kechengsheji.dao.StudentinfoDao;
import com.example.kechengsheji.model.Studentinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by chenglu on 2019-3-9.
*/
@Service
public class StudentinfoServiceImpl implements StudentinfoService {

    @Autowired
    StudentinfoDao studentinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Studentinfo studentinfo){
        return studentinfoDao.insert(studentinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Studentinfo studentinfo){
        return studentinfoDao.delete(studentinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  studentinfoDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Studentinfo studentinfo){
        return studentinfoDao.update(studentinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Studentinfo getById(Integer id){
        return studentinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Studentinfo> list(Studentinfo studentinfo){
        return studentinfoDao.list(studentinfo);
    }

}