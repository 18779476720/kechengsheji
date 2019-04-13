package com.example.kechengsheji.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
* Created by chenglu on 2019-3-25.
*/
public class Deliverinfo implements Serializable{
        /**
         *
         */
        private Integer id;
        /**
         *已投递学生id
         */
        private Integer studentId;
        /**
         *招聘信息id
         */
        private Integer recruitId;
        /**
         *投递状态
         */
        private String deliverStatus;
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

        public Integer getId() {
            return id;
        }

        public Deliverinfo setId(Integer id) {
            this.id = id;
            return this;
        }
        public Integer getStudentId() {
            return studentId;
        }

        public Deliverinfo setStudentId(Integer studentId) {
            this.studentId = studentId;
            return this;
        }
        public Integer getRecruitId() {
            return recruitId;
        }

        public Deliverinfo setRecruitId(Integer recruitId) {
            this.recruitId = recruitId;
            return this;
        }
        public String getDeliverStatus() {
            return deliverStatus;
        }

        public Deliverinfo setDeliverStatus(String deliverStatus) {
            this.deliverStatus = deliverStatus;
            return this;
        }
        public Integer getCreatedBy() {
            return createdBy;
        }

        public Deliverinfo setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
            return this;
        }
        public Date getCreateDate() {
            return createDate;
        }

        public Deliverinfo setCreateDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }
        public Integer getLastUpdateBy() {
            return lastUpdateBy;
        }

        public Deliverinfo setLastUpdateBy(Integer lastUpdateBy) {
            this.lastUpdateBy = lastUpdateBy;
            return this;
        }
        public Date getLastUpdateDate() {
            return lastUpdateDate;
        }

        public Deliverinfo setLastUpdateDate(Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }
}
