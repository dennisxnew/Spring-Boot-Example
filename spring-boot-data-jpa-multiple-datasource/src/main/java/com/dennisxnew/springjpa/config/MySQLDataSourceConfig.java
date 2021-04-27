package com.dennisxnew.springjpa.config;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dennis.Chen
 * @Date 20200427
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.dennisxnew.springjpa.dao.mysql.repo",
        entityManagerFactoryRef = "mySQLEntityManagerFactory",
        transactionManagerRef = "mySQLPlatformTransactionManager"
)
public class MySQLDataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(value="spring.datasource.mysql")
    public DataSource mySQLDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mySQLEntityManagerFactory(@Qualifier("mySQLDataSource") DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan(new String[]{"com.dennisxnew.springjpa.model.mysql"});

        //調查一下這個用途是啥??
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("show-sql", true);
        entityManager.setJpaPropertyMap(properties);

        return entityManager;
    }

    @Bean
    @Primary
    public PlatformTransactionManager mySQLPlatformTransactionManager(@Qualifier("mySQLEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManager){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager.getObject());

        return transactionManager;
    }

    @Bean
    @Primary
    public JdbcTemplate mySQLJdbcTemplate(@Qualifier("mySQLDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
