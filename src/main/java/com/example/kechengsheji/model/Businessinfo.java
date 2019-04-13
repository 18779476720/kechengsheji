package com.example.kechengsheji.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
* Created by chenglu on 2019-3-25.
*/
public class Businessinfo implements Serializable{
        /**
         *
         */
        private Integer id;
        /**
         *商家名称
         */
        private String businessName;
        /**
         *商家信息描述
         */
        private String businessDescription;
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

        public Businessinfo setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getBusinessDescription() {
                return businessDescription;
            }

        public Businessinfo setBusinessDescription(String businessDescription) {
            this.businessDescription = businessDescription;
            return this;
        }
        public Integer getCreatedBy() {
            return createdBy;
        }

        public Businessinfo setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
            return this;
        }
        public Date getCreateDate() {
            return createDate;
        }

        public Businessinfo setCreateDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }
        public Integer getLastUpdateBy() {
            return lastUpdateBy;
        }

        public Businessinfo setLastUpdateBy(Integer lastUpdateBy) {
            this.lastUpdateBy = lastUpdateBy;
            return this;
        }
        public Date getLastUpdateDate() {
            return lastUpdateDate;
        }

        public Businessinfo setLastUpdateDate(Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }
}
