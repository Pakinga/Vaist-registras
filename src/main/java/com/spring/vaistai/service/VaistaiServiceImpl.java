package com.spring.vaistai.service;

import com.spring.vaistai.model.Vaistai;
import com.spring.vaistai.model.VaistaiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaistaiServiceImpl implements VaistaiService{
    @Autowired
    @Qualifier("VaistaiDAO")
    private VaistaiDAO vaistaiDAO;

    @Override
    public List<Vaistai> getAll(){
        return vaistaiDAO.findEntities();
    }

    @Override
    public void save(Vaistai vaistai){
        vaistaiDAO.insertEntity(vaistai);
    }

    @Override
    public Vaistai getById(int  id){
        return vaistaiDAO.findEntityByID(id);
    }

    @Override
    public void update(Vaistai vaistai){
        vaistaiDAO.updateEntity(vaistai);
    }

    @Override
    public void delete(int id){
        vaistaiDAO.removeEntityByID(id);
    }
}
