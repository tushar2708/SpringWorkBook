package com.tushar.spring_practice.cdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeCdiService {

    @Autowired
    SomeCdiDao someCdiDao;

    public SomeCdiDao getsomeCdiDao() {
        return someCdiDao;
    }

    public void setsomeCdiDao(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }

}
