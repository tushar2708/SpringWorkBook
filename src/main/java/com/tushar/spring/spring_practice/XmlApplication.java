package com.tushar.spring.spring_practice;

import com.tushar.spring.spring_practice.xml.XmlPersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Configuration
//@ComponentScan({"com.tushar.spring.spring_practice", "com.tushar.spring.itHasComponents"})
public class XmlApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(XmlApplication.class);


    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {

            LOGGER.info("applicationContext.getBeanDefinitionCount(): {}", applicationContext.getBeanDefinitionCount());
            // Have to add a typecasting to (Object), because otherwise LOGGER will only print the first member of the array
            LOGGER.info("applicationContext.getBeanDefinitionNames(): {}", (Object) applicationContext.getBeanDefinitionNames());
            // Output of above statement = "[xmlJdbcConnection, xmlPersonDao]"

            XmlPersonDao xmlPersonDao = applicationContext.getBean(XmlPersonDao.class);
            XmlPersonDao xmlPersonDao1 = applicationContext.getBean(XmlPersonDao.class);

            LOGGER.info("xmlPersonDao: {}", xmlPersonDao);
            LOGGER.info("xmlPersonDao1: {}", xmlPersonDao1);

            LOGGER.info("xmlPersonDao.getXmlJdbcConnection: {}", xmlPersonDao.getXmlJdbcConnection());
            LOGGER.info("xmlPersonDao1.getXmlJdbcConnection: {}", xmlPersonDao1.getXmlJdbcConnection());

        }
    }
}
