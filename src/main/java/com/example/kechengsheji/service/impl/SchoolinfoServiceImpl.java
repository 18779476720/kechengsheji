package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.SchoolinfoService;
import com.example.kechengsheji.dao.SchoolinfoDao;
import com.example.kechengsheji.model.Schoolinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by chenglu on 2019-3-9.
*/
@Service
public class SchoolinfoServiceImpl implements SchoolinfoService {

    @Autowired
    SchoolinfoDao schoolinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Schoolinfo schoolinfo){
        return schoolinfoDao.insert(schoolinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Schoolinfo schoolinfo){
        return schoolinfoDao.delete(schoolinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  schoolinfoDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Schoolinfo schoolinfo){
        return schoolinfoDao.update(schoolinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Schoolinfo getById(Integer id){
        return schoolinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Schoolinfo> list(Schoolinfo schoolinfo){
        return schoolinfoDao.list(schoolinfo);
    }

}