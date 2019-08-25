package com.tushar.spring_practice;

import com.tushar.spring_practice.scopes.dummyDao.PersonDAO;
import com.tushar.spring_practice.scopes.dummyDao.PersonDAOPrototype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ComponentScanApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(ComponentScanApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ComponentScanApplication.class, args);

        LOGGER.info("getApplicationName: {}", applicationContext.getApplicationName());
        LOGGER.info("getDisplayName: {}", applicationContext.getDisplayName());
        LOGGER.info("getStartupDate: {}", applicationContext.getStartupDate());

        PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
        PersonDAO personDAO1 = applicationContext.getBean(PersonDAO.class);

        // Both personDAO & personDAO1 are same instances
        LOGGER.info("personDAO: {}", personDAO);
        LOGGER.info("personDAO1: {}", personDAO1);

        // All of these them still have same JDBC connection instances, even though JdbcConnection is of Prototype kind
        LOGGER.info("personDAOPrototype.getJdbcConnection 1: {}", personDAO.getJdbcConnection());
        LOGGER.info("personDAOPrototype.getJdbcConnection 2: {}", personDAO.getJdbcConnection());
        LOGGER.info("personDAOPrototype1.getJdbcConnection: {}", personDAO1.getJdbcConnection());

        PersonDAOPrototype personDAOPrototype = applicationContext.getBean(PersonDAOPrototype.class);
        PersonDAOPrototype personDAOPrototype1 = applicationContext.getBean(PersonDAOPrototype.class);

        // Both personDAOPrototype & personDAOPrototype1 are different instances
        LOGGER.info("personDAOPrototype: {}", personDAOPrototype);
        LOGGER.info("personDAOPrototype1: {}", personDAOPrototype1);

        // But both of them still have same JDBC connection instances
        LOGGER.info("personDAOPrototype.getJdbcConnection: {}", personDAOPrototype.getJdbcConnection());
        LOGGER.info("personDAOPrototype1.getJdbcConnection: {}", personDAOPrototype1.getJdbcConnection());

    }
}
