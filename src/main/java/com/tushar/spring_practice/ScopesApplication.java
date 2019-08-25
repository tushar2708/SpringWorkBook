package com.tushar.spring_practice;

import com.tushar.itHasComponents.ComponentDAO;
import com.tushar.spring_practice.scopes.dummyDao.PersonDAO;
import com.tushar.spring_practice.scopes.dummyDao.PersonDAOPrototype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tushar.itHasComponents")
public class ScopesApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(ScopesApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ScopesApplication.class, args);

        LOGGER.info("getApplicationName: {}", applicationContext.getApplicationName());
        LOGGER.info("getDisplayName: {}", applicationContext.getDisplayName());
        LOGGER.info("getStartupDate: {}", applicationContext.getStartupDate());

        ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
        ComponentDAO componentDAO1 = applicationContext.getBean(ComponentDAO.class);

        // Both personDAO & personDAO1 are same instances
        LOGGER.info("componentDAO: {}", componentDAO);
        LOGGER.info("componentDAO: {}", componentDAO1);

        // All of these them still have same JDBC connection instances, even though JdbcConnection is of Prototype kind
        LOGGER.info("componentDAO.getJdbcConnection 1: {}", componentDAO.getComponentJdbcConnection());
        LOGGER.info("componentDAO.getJdbcConnection 2: {}", componentDAO.getComponentJdbcConnection());
        LOGGER.info("componentDAO1.getJdbcConnection: {}", componentDAO1.getComponentJdbcConnection());

    }
}
