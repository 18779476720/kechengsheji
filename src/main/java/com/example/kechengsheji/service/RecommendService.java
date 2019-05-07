package com.example.kechengsheji.service;

import com.example.kechengsheji.model.Deliverinfo;
import com.example.kechengsheji.model.Recruitinfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RecommendService {
    PageInfo<Recruitinfo> getAll(List<Deliverinfo> list);
}
