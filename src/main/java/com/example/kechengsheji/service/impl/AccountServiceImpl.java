package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.dao.SchoolinfoDao;
import com.example.kechengsheji.dao.StudentinfoDao;
import com.example.kechengsheji.model.AccountParams;
import com.example.kechengsheji.model.Schoolinfo;
import com.example.kechengsheji.model.Studentinfo;
import com.example.kechengsheji.service.AccountService;
import com.example.kechengsheji.dao.AccountDao;
import com.example.kechengsheji.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.*;
/**
* Created by chenglu on 2019-3-9.
*/

@Component
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    SchoolinfoDao schoolinfoDao;

    @Autowired
    StudentinfoDao studentinfoDao;

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean saveOrUpdateAccount(AccountParams params) {
        Account accountVo = new Account();
        accountVo.setAccountname(params.getAccountname());
        accountVo.setPassword(params.getPassword());
        accountVo.setRole(params.getRole());

        JSONObject studentInfo = JSONObject.parseObject(params.getStudentInfo());
        Studentinfo studentVo = new Studentinfo();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if(studentInfo != null){
            studentVo.setAccountname(params.getAccountname());
            studentVo.setPhone(studentInfo.getString("phone"));
            studentVo.setEmail(studentInfo.getString("email"));
            studentVo.setHopeJob(studentInfo.getString("hopeJob"));
            String dateTimeString = studentInfo.getString("dateTime");
            String format1 = "yyyy-MM-dd";
            Date date = null;
            try {
                date = new SimpleDateFormat(format1).parse(dateTimeString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            studentVo.setDateTime(date);
            studentVo.setMajorName(studentInfo.getString("majorName"));
            studentVo.setSex(studentInfo.getString("sex"));
            studentVo.setStudentName(studentInfo.getString("studentName"));
            String enrollmentYearString = studentInfo.getString("enrollmentYear");
            Date date1 = null;
            try {
                date1 = new SimpleDateFormat(format1).parse(enrollmentYearString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            studentVo.setEnrollmentYear(date1);
        }
        JSONObject schoolInfo = JSONObject.parseObject(params.getSchoolInfo());
        Schoolinfo schoolVo = new Schoolinfo();
        if(schoolInfo != null){
            schoolVo.setSchoolAddress(schoolInfo.getString("schoolAddress"));
            schoolVo.setSchoolCode(null);
            schoolVo.setSchoolName(schoolInfo.getString("schoolName"));
        }
        //判断新增还是更新
        Account account = accountDao.getByAccountname(params.getAccountname());
        //新增
        if(account == null){
            accountDao.insert(accountVo);
            schoolinfoDao.insert(schoolVo);
            studentVo.setSchoolId(schoolVo.getId());
            studentinfoDao.insert(studentVo);
        }
        //修改
        if(account != null){
            accountDao.update(accountVo);
            Studentinfo newStudentVo = studentinfoDao.getByName(accountVo.getAccountname());
            schoolVo.setId(newStudentVo.getSchoolId());
            schoolinfoDao.update(schoolVo);
            studentVo.setSchoolId(schoolVo.getId());
            studentinfoDao.updateByAccountName(studentVo);
        }
        return true;
    }
}