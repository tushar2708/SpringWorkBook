package com.tushar.spring.spring_practice.xml;

// If a bean is managed via XML, following annotations aren't needed
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class XmlJdbcConnection {

    public XmlJdbcConnection() {
        System.out.println("JdbcConnection");
    }

}
