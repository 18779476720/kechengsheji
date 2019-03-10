package com.example.kechengsheji.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
* Created by chenglu on 2019-3-9.
*/
public class Majorinfo implements Serializable{
        /**
         *
         */
        private Integer id;
        /**
         *专业名称
         */
        private String majorName;
        /**
         *专业编码
         */
        private String majorId;
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

        public Majorinfo setId(Integer id) {
            this.id = id;
            return this;
        }
        public String getMajorName() {
            return majorName;
        }

        public Majorinfo setMajorName(String majorName) {
            this.majorName = majorName;
            return this;
        }
        public String getMajorId() {
            return majorId;
        }

        public Majorinfo setMajorId(String majorId) {
            this.majorId = majorId;
            return this;
        }
        public Integer getCreatedBy() {
            return createdBy;
        }

        public Majorinfo setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
            return this;
        }
        public Date getCreateDate() {
            return createDate;
        }

        public Majorinfo setCreateDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }
        public Integer getLastUpdateBy() {
            return lastUpdateBy;
        }

        public Majorinfo setLastUpdateBy(Integer lastUpdateBy) {
            this.lastUpdateBy = lastUpdateBy;
            return this;
        }
        public Date getLastUpdateDate() {
            return lastUpdateDate;
        }

        public Majorinfo setLastUpdateDate(Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }
}
