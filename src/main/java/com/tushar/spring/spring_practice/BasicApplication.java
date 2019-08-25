package com.tushar.spring.spring_practice;

import com.tushar.spring.spring_practice.basics.searching.BinarySearchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(BasicApplication.class);


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BasicApplication.class, args);

        LOGGER.info("getApplicationName: " + applicationContext.getApplicationName());
        LOGGER.info("getDisplayName: " + applicationContext.getDisplayName());
        LOGGER.info("getStartupDate: " + applicationContext.getStartupDate());

        BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
        BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);

        // Both binarySearch & binarySearch1 are same instances
        LOGGER.info("binarySearch: {}", binarySearch);
        LOGGER.info("binarySearch1: {}", binarySearch1);


        int result = binarySearch.binarySearch(new int[]{12, 4, 6}, 3);
        LOGGER.info("result:" + result);
    }
}
