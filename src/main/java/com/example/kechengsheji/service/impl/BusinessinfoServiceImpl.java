package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.model.Recruitinfo;
import com.example.kechengsheji.service.BusinessinfoService;
import com.example.kechengsheji.dao.BusinessinfoDao;
import com.example.kechengsheji.model.Businessinfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by chenglu on 2019-3-25.
*/
@Service
public class BusinessinfoServiceImpl implements BusinessinfoService {

    @Autowired
    BusinessinfoDao businessinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Businessinfo businessinfo){
        return businessinfoDao.insert(businessinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Businessinfo businessinfo){
        return businessinfoDao.delete(businessinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  businessinfoDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Businessinfo businessinfo){
        return businessinfoDao.update(businessinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Businessinfo getById(Integer id){
        return businessinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Businessinfo getByAccountName(String accountName){
        return businessinfoDao.getByAccountName(accountName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Businessinfo updateBusinessInfoByAccountName(Businessinfo businessinfo){
        return businessinfoDao.updateBusinessInfoByAccountName(businessinfo);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Businessinfo> list(Businessinfo businessinfo){
        return businessinfoDao.list(businessinfo);
    }

}