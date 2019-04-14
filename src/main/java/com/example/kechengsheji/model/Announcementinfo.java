package com.example.kechengsheji.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenglu on 2019-3-25.
 */
public class Announcementinfo implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 公告标题
     */
    private String announcementName;
    /**
     * 公告信息
     */
    private String announcementInfo;
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

    public String getAnnouncementName() {
        return announcementName;
    }

    public void setAnnouncementName(String announcementName) {
        this.announcementName = announcementName;
    }

    public Announcementinfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAnnouncementInfo() {
        return announcementInfo;
    }

    public Announcementinfo setAnnouncementInfo(String announcementInfo) {
        this.announcementInfo = announcementInfo;
        return this;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Announcementinfo setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Announcementinfo setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public Announcementinfo setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Announcementinfo setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }
}
