package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.RecruitinfoService;
import com.example.kechengsheji.dao.RecruitinfoDao;
import com.example.kechengsheji.model.Recruitinfo;
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
public class RecruitinfoServiceImpl implements RecruitinfoService {

    @Autowired
    RecruitinfoDao recruitinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Recruitinfo recruitinfo){
        return recruitinfoDao.insert(recruitinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Recruitinfo recruitinfo){
        return recruitinfoDao.delete(recruitinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  recruitinfoDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Recruitinfo recruitinfo){
        return recruitinfoDao.update(recruitinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Recruitinfo getById(Integer id){
        return recruitinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Recruitinfo> list(Recruitinfo recruitinfo){
        return recruitinfoDao.list(recruitinfo);
    }

    //分页查询
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PageInfo<Recruitinfo> getAll(Recruitinfo recruitinfo, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Recruitinfo> list = recruitinfoDao.list(recruitinfo);
        PageInfo<Recruitinfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}