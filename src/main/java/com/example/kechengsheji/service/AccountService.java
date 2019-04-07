package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Account;
import com.example.kechengsheji.model.AccountParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by chenglu on 2019-3-9.
*/
public interface AccountService {

    int insert(Account account);

    int delete(Account account);

    int deleteByIds(Integer[] ids);

    int update(Account account);

    Account getById(Integer id);

    List<Account> list(Account account);

    Account getByAccountname(String name);

    int selectCount(@Param("accountname") String name);

    boolean saveOrUpdateAccount(AccountParams params);
}