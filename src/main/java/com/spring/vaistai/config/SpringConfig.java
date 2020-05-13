package com.spring.vaistai.config;

import com.spring.vaistai.model.VaistaiDAO;
import com.spring.vaistai.model.VaistaiDAOImpl;
import com.spring.vaistai.service.VaistaiService;
import com.spring.vaistai.service.VaistaiServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    @Qualifier("VaistaiDAO")
    public VaistaiDAO getNumberDAO(){
        return new VaistaiDAOImpl();
    }

    @Bean
    @Qualifier("VaistaiService")
    public VaistaiService getNumberService(){
        return new VaistaiServiceImpl();
    }
}
