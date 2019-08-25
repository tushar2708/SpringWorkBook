package com.tushar.spring_practice.scopes.connections;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class JdbcConnection {

    public JdbcConnection(){
        System.out.println("JdbcConnection");
    }

}
