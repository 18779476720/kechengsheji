package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.dao.DeliverinfoDao;
import com.example.kechengsheji.model.Deliverinfo;
import com.example.kechengsheji.service.ScoreinfoService;
import com.example.kechengsheji.dao.ScoreinfoDao;
import com.example.kechengsheji.model.Scoreinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by chenglu on 2019-3-25.
 */
@Service
@Component
public class ScoreinfoServiceImpl implements ScoreinfoService {

    @Autowired
    ScoreinfoDao scoreinfoDao;

    @Autowired
    DeliverinfoDao deliverinfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Scoreinfo scoreinfo){

        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());

        String format1 = "yyyy-MM-dd";
        try {
            date = new SimpleDateFormat(format1).parse(String.valueOf(timeStamep));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        scoreinfo.setCreateDate(date);
        int num = scoreinfoDao.insert(scoreinfo);
        if(num > 0){
            Deliverinfo deliverinfo = new Deliverinfo();
            deliverinfo.setAccountId(scoreinfo.getAccountId());
            deliverinfo.setRecruitId(scoreinfo.getRecruitId());
            deliverinfo.setDeliverStatus("已评价");
            deliverinfoDao.update(deliverinfo);
        }
        return 1;
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