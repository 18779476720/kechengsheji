package com.example.kechengsheji.model;
/**
* @Description:    查询投递某条招聘信息的所有人详情
* @Author:          longhua.wang
* @CreateDate:     2019/4/30 11:43
* @UpdateUser:     longhua.wang
* @UpdateDate:     2019/4/30 11:43
*/
public class DeliveryDetailParams extends Deliverinfo{
    /**
     *学生信息
     */
    private String studentInfo;

    /**
     *学校信息
     */
    private String schoolInfo;

    /**
     *招聘信息
     */
    private String recruitInfo;

    public String getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }

    public String getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(String schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    public String getRecruitInfo() {
        return recruitInfo;
    }

    public void setRecruitInfo(String recruitInfo) {
        this.recruitInfo = recruitInfo;
    }
}
