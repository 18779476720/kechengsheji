package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.MajorinfoService;
import com.example.kechengsheji.dao.MajorinfoDao;
import com.example.kechengsheji.model.Majorinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by chenglu on 2019-3-9.
*/
@Service
public class MajorinfoServiceImpl implements MajorinfoService {

    @Autowired
    MajorinfoDao majorinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Majorinfo majorinfo){
        return majorinfoDao.insert(majorinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Majorinfo majorinfo){
        return majorinfoDao.delete(majorinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  majorinfoDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Majorinfo majorinfo){
        return majorinfoDao.update(majorinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Majorinfo getById(Integer id){
        return majorinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Majorinfo> list(Majorinfo majorinfo){
        return majorinfoDao.list(majorinfo);
    }

}