package com.tushar.spring.spring_practice.basics.searching;

import com.tushar.spring.spring_practice.basics.sorting.SortAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {

    private static Logger LOGGER = LoggerFactory.getLogger(BinarySearchImpl.class);

    @Autowired
    private SortAlgorithm bubbleSortAlgorithm;

    // This constructor will be used to inject singleton instance to "sortAlgorithm"
//    @Autowired
    public BinarySearchImpl(SortAlgorithm bubbleSortAlgorithm) {
        this.bubbleSortAlgorithm = bubbleSortAlgorithm;
    }

    // This setter will be used to inject singleton instance to "sortAlgorithm"
//    @Autowired
//    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
        LOGGER.info("bubbleSortAlgorithm: {}", bubbleSortAlgorithm);

        // Search the array
        return 3;
    }

    @PostConstruct
    public void postConstruct(){
        LOGGER.info("postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        LOGGER.info("preDestroy");
    }
}
