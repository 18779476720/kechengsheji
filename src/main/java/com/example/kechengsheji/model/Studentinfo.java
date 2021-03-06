package com.example.kechengsheji.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenglu on 2019-3-9.
 */
public class Studentinfo implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 用户名
     */
    private String accountname;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private String email;
    /**
     * 学校id
     */
    private Integer schoolId;
    /**
     * 期望工作
     */
    private String hopeJob;

    /**
     * 专业id
     */
    private String majorName;
    /**
     *
     */
    private String sex;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 入学年份
     */
    private Date enrollmentYear;
    /**
     * 出生年月
     */
    private Date dateTime;
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
    private Date lastUpdateDate;

    private String hopeJob1;

    private  Integer startTime;

    private Integer endTime;

    public Integer getId() {
        return id;
    }

    public Studentinfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccountname() {
        return accountname;
    }

    public Studentinfo setAccountname(String accountname) {
        this.accountname = accountname;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Studentinfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Studentinfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public Studentinfo setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    public String getMajorName() {
        return this.majorName;
    }

    public Studentinfo setMajorName(String majorName) {
        this.majorName = majorName;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Studentinfo setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public Studentinfo setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public Date getEnrollmentYear() {
        return enrollmentYear;
    }

    public Studentinfo setEnrollmentYear(Date enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
        return this;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Studentinfo setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Studentinfo setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Studentinfo setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public Studentinfo setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Studentinfo setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public String getHopeJob() {
        return hopeJob;
    }

    public void setHopeJob(String hopeJob) {
        this.hopeJob = hopeJob;
    }

    public String getHopeJob1() {
        return hopeJob1;
    }

    public void setHopeJob1(String hopeJob1) {
        this.hopeJob1 = hopeJob1;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
