package com.tushar.spring.spring_practice.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {

    @Autowired
    JdbcConnectionPrototype jdbcConnectionPrototype;

    public JdbcConnectionPrototype getJdbcConnection() {
        return jdbcConnectionPrototype;
    }

    public void setJdbcConnection(JdbcConnectionPrototype jdbcConnectionPrototype) {
        this.jdbcConnectionPrototype = jdbcConnectionPrototype;
    }

}
