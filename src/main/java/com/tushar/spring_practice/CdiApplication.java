package com.tushar.spring_practice;

import com.tushar.itHasComponents.ComponentDAO;
import com.tushar.spring_practice.cdi.SomeCdiDao;
import com.tushar.spring_practice.cdi.SomeCdiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tushar.itHasComponents")
public class CdiApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(CdiApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CdiApplication.class, args);

        LOGGER.info("getApplicationName: {}", applicationContext.getApplicationName());
        LOGGER.info("getDisplayName: {}", applicationContext.getDisplayName());
        LOGGER.info("getStartupDate: {}", applicationContext.getStartupDate());

        SomeCdiService someCdiService = applicationContext.getBean(SomeCdiService.class);
        SomeCdiService someCdiService1 = applicationContext.getBean(SomeCdiService.class);

        // Both personDAO & personDAO1 are same instances
        LOGGER.info("someCdiService: {}", someCdiService);
        LOGGER.info("someCdiService1: {}", someCdiService1);

        // All of these them still have same JDBC connection instances, even though JdbcConnection is of Prototype kind
        LOGGER.info("someCdiService.getsomeCdiDao 1: {}", someCdiService.getsomeCdiDao());
        LOGGER.info("someCdiService.getsomeCdiDao 2: {}", someCdiService.getsomeCdiDao());
        LOGGER.info("someCdiService1.getsomeCdiDao: {}", someCdiService1.getsomeCdiDao());
    }
}
