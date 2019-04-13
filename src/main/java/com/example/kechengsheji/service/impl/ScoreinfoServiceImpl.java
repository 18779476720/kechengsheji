package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.ScoreinfoService;
import com.example.kechengsheji.dao.ScoreinfoDao;
import com.example.kechengsheji.model.Scoreinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by chenglu on 2019-3-25.
*/
@Service
@Component
public class ScoreinfoServiceImpl implements ScoreinfoService {

    @Autowired
    ScoreinfoDao scoreinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Scoreinfo scoreinfo){
        return scoreinfoDao.insert(scoreinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Scoreinfo scoreinfo){
        return scoreinfoDao.delete(scoreinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  scoreinfoDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Scoreinfo scoreinfo){
        return scoreinfoDao.update(scoreinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Scoreinfo getById(Integer id){
        return scoreinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Scoreinfo> list(Scoreinfo scoreinfo){
        return scoreinfoDao.list(scoreinfo);
    }

}