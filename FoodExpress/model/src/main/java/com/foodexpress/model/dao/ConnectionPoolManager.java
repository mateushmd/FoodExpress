package com.foodexpress.model.dao;

import org.apache.commons.dbcp2.BasicDataSource;


public class ConnectionPoolManager {
    private static BasicDataSource dataSource;
    
    static {
        dataSource = new BasicDataSource();
        
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_b695d40b1c0e531?useSSL=false");
        dataSource.setUsername("b4ef7c73d61cc7");
        dataSource.setPassword("c101e0f6");
        
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(20);
    }
    
    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}
