package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.dao.HistoryDao;
import com.example.kechengsheji.model.History;
import com.example.kechengsheji.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    HistoryDao historyDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(History history){
        return historyDao.insert(history);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(History history){
        return historyDao.delete(history);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  historyDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(History history){
        return historyDao.update(history);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public History getById(Integer id){
        return historyDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<History> list(History history){
        return historyDao.list(history);
    }
}
