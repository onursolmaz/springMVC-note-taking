package com;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.beans.PropertyVetoException;
import java.util.Properties;

public class Connection {

    // bu kısmı spring e devrediyoruz

//    private ComboPooledDataSource connection() throws PropertyVetoException {
//        ComboPooledDataSource cpds= new ComboPooledDataSource();
//
//        cpds.setDriverClass("com.mysql.jdbc.Driver");
//        cpds.setJdbcUrl("jdbc:mysql://localhost/springmvc");
//        cpds.setUser("root");
//        cpds.setPassword("1234");
//        return cpds;
//    }
//
//    public SessionFactory sessionFactory() throws PropertyVetoException {
//
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(connection());
//
//        Properties properties= new Properties();
//
//        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
//        properties.setProperty("hibernate.hbm2ddl.auto","update");
//        properties.setProperty("hibernate.format_sql","true");
//
//        sessionFactory.setHibernateProperties(properties);
//        sessionFactory.setPackagesToScan("com.Entities");
//
//        return (SessionFactory)sessionFactory;
//
//    }


}
