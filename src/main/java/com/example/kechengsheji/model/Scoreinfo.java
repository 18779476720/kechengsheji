package com.example.kechengsheji.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
* Created by chenglu on 2019-3-25.
*/
public class Scoreinfo implements Serializable{
        /**
         *
         */
        private Integer id;
        /**
         *评价学生id
         */
        private Integer studentId;
        /**
         *招聘信息id
         */
        private Integer recruitId;
        /**
         *评分数  分为  1 2 3 4 5 
         */
        private String scoreNum;
        /**
         *评价描述
         */
        private String scoreDescription;
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

        public Scoreinfo setId(Integer id) {
            this.id = id;
            return this;
        }
        public Integer getStudentId() {
            return studentId;
        }

        public Scoreinfo setStudentId(Integer studentId) {
            this.studentId = studentId;
            return this;
        }
        public Integer getRecruitId() {
            return recruitId;
        }

        public Scoreinfo setRecruitId(Integer recruitId) {
            this.recruitId = recruitId;
            return this;
        }
        public String getScoreNum() {
            return scoreNum;
        }

        public Scoreinfo setScoreNum(String scoreNum) {
            this.scoreNum = scoreNum;
            return this;
        }
        public String getScoreDescription() {
            return scoreDescription;
        }

        public Scoreinfo setScoreDescription(String scoreDescription) {
            this.scoreDescription = scoreDescription;
            return this;
        }
        public Integer getCreatedBy() {
            return createdBy;
        }

        public Scoreinfo setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
            return this;
        }
        public Date getCreateDate() {
            return createDate;
        }

        public Scoreinfo setCreateDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }
        public Integer getLastUpdateBy() {
            return lastUpdateBy;
        }

        public Scoreinfo setLastUpdateBy(Integer lastUpdateBy) {
            this.lastUpdateBy = lastUpdateBy;
            return this;
        }
        public Date getLastUpdateDate() {
            return lastUpdateDate;
        }

        public Scoreinfo setLastUpdateDate(Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }
}
