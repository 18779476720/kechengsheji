package com.example.kechengsheji.service;

import com.example.kechengsheji.model.History;

import java.util.List;

public interface HistoryService {
    int insert(History history);

    int delete(History history);

    int deleteByIds(Integer[] ids);

    int update(History history);

    History getById(Integer id);

    List<History> list(History history);
}
