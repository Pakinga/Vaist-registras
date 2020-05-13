package com.spring.vaistai.model;

import java.util.List;

public interface VaistaiDAO {
    void insertEntity(Vaistai vaistai);
    Vaistai findEntityByID(int id);
    List<Vaistai> findEntities();
    void updateEntity(Vaistai vaistai);
    void removeEntityByID(int id);
}
