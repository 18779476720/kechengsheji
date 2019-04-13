package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.AnnouncementinfoService;
import com.example.kechengsheji.dao.AnnouncementinfoDao;
import com.example.kechengsheji.model.Announcementinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* Created by chenglu on 2019-3-25.
*/
@Service
public class AnnouncementinfoServiceImpl implements AnnouncementinfoService {

    @Autowired
    AnnouncementinfoDao announcementinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Announcementinfo announcementinfo){
        return announcementinfoDao.insert(announcementinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Announcementinfo announcementinfo){
        return announcementinfoDao.delete(announcementinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  announcementinfoDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Announcementinfo announcementinfo){
        return announcementinfoDao.update(announcementinfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Announcementinfo getById(Integer id){
        return announcementinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Announcementinfo> list(Announcementinfo announcementinfo){
        return announcementinfoDao.list(announcementinfo);
    }

}