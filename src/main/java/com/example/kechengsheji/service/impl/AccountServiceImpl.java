package com.example.kechengsheji.service.impl;

import com.example.kechengsheji.dao.BusinessinfoDao;
import com.example.kechengsheji.dao.SchoolinfoDao;
import com.example.kechengsheji.dao.StudentinfoDao;
import com.example.kechengsheji.model.*;
import com.example.kechengsheji.service.AccountService;
import com.example.kechengsheji.dao.AccountDao;
import com.example.kechengsheji.model.Account;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Autowired
    BusinessinfoDao businessinfoDao;

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
        if(params.getId() == null){
            accountVo.setAccountname(params.getAccountname());
            accountVo.setPassword(params.getPassword());
            accountVo.setRole(params.getRole());
        }else{
            Account account = accountDao.getById(params.getId());
            accountVo.setAccountname(params.getAccountname());
            accountVo.setPassword(params.getPassword());
            accountVo.setRole(account.getRole());
        }
        if("1".equals(accountVo.getRole())){
            JSONObject studentInfo = JSONObject.parseObject(params.getStudentInfo());
            Studentinfo studentVo = new Studentinfo();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if(studentInfo != null){
                studentVo.setAccountname(params.getAccountname());
                studentVo.setPhone(studentInfo.getString("phone"));
                studentVo.setEmail(studentInfo.getString("email"));
                studentVo.setHopeJob(studentInfo.getString("hopeJob"));
                studentVo.setHopeJob1(studentInfo.getString("hopeJob1"));
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
                studentVo.setStartTime(studentInfo.getInteger("startTime"));
                studentVo.setEndTime(studentInfo.getInteger("endTime"));
                studentVo.setStudentName(studentInfo.getString("studentName"));
            }
            JSONObject schoolInfo = JSONObject.parseObject(params.getSchoolInfo());
            Schoolinfo schoolVo = new Schoolinfo();
            if(schoolInfo != null){
                schoolVo.setSchoolAddress(schoolInfo.getString("schoolAddress"));
                schoolVo.setSchoolCode(null);
                schoolVo.setSchoolName(schoolInfo.getString("schoolName"));
            }
            if(params.getId() == null){
                accountDao.insert(accountVo);
                schoolinfoDao.insert(schoolVo);
                studentVo.setSchoolId(schoolVo.getId());
                studentinfoDao.insert(studentVo);
            }
            //修改
            if(params.getId() != null){
                Account accountEditVo = accountDao.getById(params.getId());
                accountVo.setId(params.getId());
                accountDao.update(accountVo);
                Studentinfo newStudentVo = studentinfoDao.getByName(accountEditVo.getAccountname());
                schoolVo.setId(newStudentVo.getSchoolId());
                schoolinfoDao.update(schoolVo);
                studentVo.setSchoolId(schoolVo.getId());
                studentVo.setId(newStudentVo.getId());
                studentinfoDao.update(studentVo);
            }
        }else if("2".equals(accountVo.getRole())){
            JSONObject businessInfo = JSONObject.parseObject(params.getBusinessInfo());
            Businessinfo businessVo = new Businessinfo();
            if(businessInfo != null){
                businessVo.setBusinessName(businessInfo.getString("businessName"));
                businessVo.setBusinessDescription(businessInfo.getString("businessDescription"));
                businessVo.setAccountname(params.getAccountname());
                businessVo.setBusinessEmail(businessInfo.getString("businessEmail"));
            }
            //新增
            if(params.getId() == null){
                accountDao.insert(accountVo);
                businessinfoDao.insert(businessVo);
            }
            //修改
            if(params.getId() != null){
                Account accountEditVo = accountDao.getById(params.getId());
                accountVo.setId(params.getId());
                accountDao.update(accountVo);
                Businessinfo businessinfo1 = businessinfoDao.getByAccountName(accountEditVo.getAccountname());
//                businessinfoDao.updateBusinessInfoByAccountName(businessVo);
                businessinfo1.setAccountname(params.getAccountname());
                businessinfo1.setBusinessName(businessInfo.getString("businessName"));
                businessinfo1.setBusinessDescription(businessInfo.getString("businessDescription"));
                businessinfo1.setBusinessEmail(businessInfo.getString("businessEmail"));
                businessinfoDao.update(businessinfo1);
            }
        }
        return true;
    }

    @Override
    public PageInfo<Account> getAll() {
        PageHelper.startPage(1,7);
        List<Account> list = accountDao.getAll();
        PageInfo<Account> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}