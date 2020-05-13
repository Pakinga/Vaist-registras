package com.spring.vaistai.service;

import com.spring.vaistai.model.Vaistai;

import java.util.List;

public interface VaistaiService {
    List<Vaistai> getAll();
    void save(Vaistai vaistai);
    Vaistai getById(int  id);
    void update(Vaistai vaistai);
    void delete(int id);
}
