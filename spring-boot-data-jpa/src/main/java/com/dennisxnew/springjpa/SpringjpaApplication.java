package com.dennisxnew.springjpa;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjpaApplication.class, args);
	}

}
