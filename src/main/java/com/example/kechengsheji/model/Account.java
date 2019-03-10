package com.example.kechengsheji.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
* Created by chenglu on 2019-3-9.
*/

public class Account implements Serializable{
        /**
         *
         */
        private Integer id;
        /**
         *账户名
         */
        private String accountname;
        /**
         *密码
         */
        private String password;
        /**
         *角色
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
        private Date lastUpdateDate;

        public Integer getId() {
            return id;
        }

        public Account setId(Integer id) {
            this.id = id;
            return this;
        }
        public String getAccountname() {
            return accountname;
        }

        public Account setAccountname(String accountname) {
            this.accountname = accountname;
            return this;
        }
        public String getPassword() {
            return password;
        }

        public Account setPassword(String password) {
            this.password = password;
            return this;
        }
        public String getRole() {
            return role;
        }

        public Account setRole(String role) {
            this.role = role;
            return this;
        }
        public Integer getCreatedBy() {
            return createdBy;
        }

        public Account setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
            return this;
        }
        public Date getCreateDate() {
            return createDate;
        }

        public Account setCreateDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }
        public Integer getLastUpdateBy() {
            return lastUpdateBy;
        }

        public Account setLastUpdateBy(Integer lastUpdateBy) {
            this.lastUpdateBy = lastUpdateBy;
            return this;
        }
        public Date getLastUpdateDate() {
            return lastUpdateDate;
        }

        public Account setLastUpdateDate(Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }
}
