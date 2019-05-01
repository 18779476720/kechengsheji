package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.DeliverinfoService;
import com.example.kechengsheji.dao.DeliverinfoDao;
import com.example.kechengsheji.model.Deliverinfo;
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
    public int updateStatus(Deliverinfo deliverinfo){
        return deliverinfoDao.updateStatus(deliverinfo);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int selectHasDelivery(Integer recruitId){
        return deliverinfoDao.selectHasDelivery(recruitId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Deliverinfo getById(Integer id){
        return deliverinfoDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Deliverinfo> list(Deliverinfo deliverinfo,Integer pageNum,Integer pageSize){
        return deliverinfoDao.list(deliverinfo);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Deliverinfo> selectHasDeliveryPerson(Integer recruitId){
        return deliverinfoDao.selectHasDeliveryPerson(recruitId);
    }

    //查询该用户是否已经投递该职位
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int selectIsHasDelivery(Integer accountId,Integer recruitId){
        return deliverinfoDao.selectIsHasDelivery(accountId,recruitId);
    }


    //分页查询
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PageInfo<Deliverinfo> getAll(Deliverinfo deliverinfo, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Deliverinfo> list = deliverinfoDao.list(deliverinfo);
        PageInfo<Deliverinfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}