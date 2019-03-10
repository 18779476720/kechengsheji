package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.service.AccountService;
import com.example.kechengsheji.dao.AccountDao;
import com.example.kechengsheji.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* Created by chenglu on 2019-3-9.
*/

@Component
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Account account){
        return accountDao.insert(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Account account){
        return accountDao.delete(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(Integer[] ids) {
        return  accountDao.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Account account){
        return accountDao.update(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Account getById(Integer id){
        return accountDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Account> list(Account account){
        return accountDao.list(account);
    }

    @Override
    public Account getByAccountname(String name) {
        return accountDao.getByAccountname(name);
    }

    @Override
    public int selectCount(String accountname) {
        // TODO Auto-generated method stub
        return accountDao.selectCount(accountname);
    }


}