package com.example.kechengsheji.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 注册用户接收参数类
 * @Author: longhua.wang
 * @CreateDate: 2019/4/6 9:33
 * @UpdateUser: longhua.wang
 * @UpdateDate: 2019/4/6 9:33
 */

public class AccountParams implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 账户名
     */
    private String accountname;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private String role;
    /**
     *
     */
    private Integer createdBy;
    /**
     *
     */
    private Date createDate;
    /**
     *
     */
    private Integer lastUpdateBy;
    /**
     *
     */
    private String studentInfo;

    /**
     *
     * @return
     */
    private String businessInfo;
    public String getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(String schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    private String schoolInfo;

    private Date lastUpdateDate;

    public Integer getId() {
        return id;
    }

    public AccountParams setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccountname() {
        return accountname;
    }

    public AccountParams setAccountname(String accountname) {
        this.accountname = accountname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AccountParams setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public AccountParams setRole(String role) {
        this.role = role;
        return this;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public AccountParams setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public AccountParams setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public AccountParams setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public AccountParams setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public String getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }

    public String getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo;
    }
}
