package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.DeliverinfoService;
import com.example.kechengsheji.dao.DeliverinfoDao;
import com.example.kechengsheji.model.Deliverinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by chenglu on 2019-3-25.
*/
@Service
public class DeliverinfoServiceImpl implements DeliverinfoService {

    @Autowired
    DeliverinfoDao deliverinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Deliverinfo deliverinfo){
        return deliverinfoDao.insert(deliverinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Deliverinfo deliverinfo){
        return deliverinfoDao.delete(deliverinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  deliverinfoDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Deliverinfo deliverinfo){
        return deliverinfoDao.update(deliverinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Deliverinfo getById(Integer id){
        return deliverinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Deliverinfo> list(Deliverinfo deliverinfo){
        return deliverinfoDao.list(deliverinfo);
    }

}