package com.tushar.spring.spring_practice.cdi;


import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCdiService {

    @Inject
    SomeCdiDao someCdiDao;

    public SomeCdiDao getsomeCdiDao() {
        return someCdiDao;
    }

    public void setsomeCdiDao(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }

}
