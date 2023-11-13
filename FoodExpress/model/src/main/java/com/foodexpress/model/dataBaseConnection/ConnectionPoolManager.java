package com.foodexpress.model.dataBaseConnection;

import org.apache.commons.dbcp2.BasicDataSource;


public class ConnectionPoolManager {
    private static final BasicDataSource dataSource;

    String oldDB = "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_b695d40b1c0e531?useSSL=false&useUnicode=true&characterEncoding=UTF-8";

    static {
        dataSource = new BasicDataSource();
        
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://foodexpress.mysql.database.azure.com:3306/foodexpress?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("cefettccfoodexpress");
        dataSource.setPassword("tccmuitochatonaguento#123456789");
        
        dataSource.setInitialSize(1);
        dataSource.setMaxTotal(5);
    }
    
    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}
