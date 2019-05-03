package com.example.kechengsheji.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * Created by chenglu on 2019-3-25.
 */
public class Recruitinfo implements Serializable{
    /**
     *
     */
    private Integer id;
    /**
     *招聘类型
     */
    private String recruitType;
    /**
     *招聘人数
     */
    private Integer recruitNum;
    /**
     *薪资描述
     */
    private String salaryDescription;
    /**
     *工作描述
     */
    private String taskDescription;
    /**
     *工作地点
     */
    private String taskPlace;
    /**
     *联系电话
     */
    private String contactNumber;
    /**
     *已投递用户id
     */
    private Integer accountId;
    /**
     *城市
     */
    private String city;
    /**
     *商家id
     */
    private Integer businessId;
    /**
     *
     */
    private String recruitStatus;
    /**
     *信息状态
     */
    private String usingStatus;
    /**
     *
     */
    private String createdBy;
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
    private Date lastUpdateDate;

    private String recruitName;

    private String recruitType1;

    private  Integer beginTime;

    private  Integer overTime;

    public Integer getId() {
        return id;
    }

    public Recruitinfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getRecruitType() {
        return recruitType;
    }

    public void setRecruitType(String recruitType) {
        this.recruitType = recruitType;
    }

    public Integer getRecruitNum() {
        return recruitNum;
    }

    public Recruitinfo setRecruitNum(Integer recruitNum) {
        this.recruitNum = recruitNum;
        return this;
    }
    public String getSalaryDescription() {
        return salaryDescription;
    }

    public Recruitinfo setSalaryDescription(String salaryDescription) {
        this.salaryDescription = salaryDescription;
        return this;
    }
    public String getTaskDescription() {
        return taskDescription;
    }

    public Recruitinfo setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
        return this;
    }
    public String getTaskPlace() {
        return taskPlace;
    }

    public Recruitinfo setTaskPlace(String taskPlace) {
        this.taskPlace = taskPlace;
        return this;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    public Recruitinfo setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }
    public Integer getAccountId() {
        return accountId;
    }

    public Recruitinfo setAccountId(Integer accountId) {
        this.accountId = accountId;
        return this;
    }
    public String getCity() {
        return city;
    }

    public Recruitinfo setCity(String city) {
        this.city = city;
        return this;
    }
    public Integer getBusinessId() {
        return businessId;
    }

    public Recruitinfo setBusinessId(Integer businessId) {
        this.businessId = businessId;
        return this;
    }
    public String getRecruitStatus() {
        return recruitStatus;
    }

    public Recruitinfo setRecruitStatus(String recruitStatus) {
        this.recruitStatus = recruitStatus;
        return this;
    }
    public String getUsingStatus() {
        return usingStatus;
    }

    public Recruitinfo setUsingStatus(String usingStatus) {
        this.usingStatus = usingStatus;
        return this;
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public Recruitinfo setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public Recruitinfo setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public Recruitinfo setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Recruitinfo setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public String getRecruitName() {
        return recruitName;
    }

    public void setRecruitName(String recruitName) {
        this.recruitName = recruitName;
    }

    public String getRecruitType1() {
        return recruitType1;
    }

    public void setRecruitType1(String recruitType1) {
        this.recruitType1 = recruitType1;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }
}
