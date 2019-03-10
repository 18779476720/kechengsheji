package com.example.kechengsheji.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
* Created by chenglu on 2019-3-9.
*/
public class Schoolinfo implements Serializable{
        /**
         *
         */
        private Integer id;
        /**
         *
         */
        private Integer studentId;
        /**
         *学校编码
         */
        private String schoolCode;
        /**
         *学校名称
         */
        private String schoolName;
        /**
         *学校地址
         */
        private String schoolAddress;
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

        public Integer getId() {
            return id;
        }

        public Schoolinfo setId(Integer id) {
            this.id = id;
            return this;
        }
        public Integer getStudentId() {
            return studentId;
        }

        public Schoolinfo setStudentId(Integer studentId) {
            this.studentId = studentId;
            return this;
        }
        public String getSchoolCode() {
            return schoolCode;
        }

        public Schoolinfo setSchoolCode(String schoolCode) {
            this.schoolCode = schoolCode;
            return this;
        }
        public String getSchoolName() {
            return schoolName;
        }

        public Schoolinfo setSchoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }
        public String getSchoolAddress() {
            return schoolAddress;
        }

        public Schoolinfo setSchoolAddress(String schoolAddress) {
            this.schoolAddress = schoolAddress;
            return this;
        }
        public String getCreatedBy() {
            return createdBy;
        }

        public Schoolinfo setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }
        public Date getCreateDate() {
            return createDate;
        }

        public Schoolinfo setCreateDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }
        public Integer getLastUpdateBy() {
            return lastUpdateBy;
        }

        public Schoolinfo setLastUpdateBy(Integer lastUpdateBy) {
            this.lastUpdateBy = lastUpdateBy;
            return this;
        }
        public Date getLastUpdateDate() {
            return lastUpdateDate;
        }

        public Schoolinfo setLastUpdateDate(Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }
}
