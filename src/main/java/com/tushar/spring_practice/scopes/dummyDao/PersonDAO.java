package com.tushar.spring_practice.scopes.dummyDao;

import com.tushar.spring_practice.scopes.connections.JdbcConnectionPrototype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

    @Autowired
    JdbcConnectionPrototype jdbcConnectionPrototype;

    public JdbcConnectionPrototype getJdbcConnection() {
        return jdbcConnectionPrototype;
    }

    public void setJdbcConnection(JdbcConnectionPrototype jdbcConnectionPrototype) {
        this.jdbcConnectionPrototype = jdbcConnectionPrototype;
    }

}
