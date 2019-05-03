package com.example.kechengsheji.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenglu on 2019-3-25.
 */
public class Businessinfo implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private String accountname;
    /**
     * 商家名称
     */
    private String businessName;
    /**
     * 商家信息描述
     */
    private String businessDescription;

    private String businessEmail;
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
    /**
     * 邮箱
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

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }
}
