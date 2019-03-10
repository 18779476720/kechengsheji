package com.example.kechengsheji.dao;
import com.example.kechengsheji.model.Account;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
* Created by chenglu on 2019-3-9.
*/
@Mapper
@Component(value = "AccountDao")
public interface AccountDao {

    int insert(Account account);

    int delete(Account account);

    int deleteByIds(@Param("ids") Integer[] ids);

    int update(Account account);

    Account getById(@Param("id") Integer id);

    List<Account> list(Account account);

    Account getByAccountname(@Param("accountname") String accountname);

    int selectCount(@Param("accountname") String name);
}