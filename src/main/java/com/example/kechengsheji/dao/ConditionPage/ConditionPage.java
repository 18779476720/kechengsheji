package com.example.kechengsheji.dao.ConditionPage;

import com.github.pagehelper.Page;

import java.util.List;

public class ConditionPage<T> {
    private Integer pageSize = 10;
    private Integer pageNum = 1;
    private Integer totalPage;

    private Page pagehelper;

    public Page getPagehelper() {
        return pagehelper;
    }

    public void setPagehelper(Page pagehelper) {
        this.pagehelper = pagehelper;
    }

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }



    public Integer getTotalPage() {
        if (data.size() % pageSize != 0) {
            totalPage = data.size() % pageSize + 1;
        } else {
            totalPage = data.size() % pageSize;
        }
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
