package com.clc.configuration;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = { "com.clc" })
@EnableWebMvc
@PropertySource("classpath:database.properties")
public class SpringHibernateConfig {
	static {
		System.out.println("spring hibernate integration..Loaded");
	}

	@Value("${hibernate.dialect}")
	private String DIALECT_VAL;

	@Value("${database.driver}")
	private String DRIVERCLASS_VAL;

	@Value("${database.user}")
	private String USERNAME_VAL;

	@Value("${database.password}")
	private String PASSWORD_VAL;

	@Value("${database.url}")
	private String DB_URL_VAL;

	@Bean("sfactory")
	public LocalSessionFactoryBean getSessionfactory() {
		LocalSessionFactoryBean localsessionfactory = new LocalSessionFactoryBean();
		localsessionfactory.setDataSource(basicDataSource());
		localsessionfactory.setPackagesToScan("com.clc");
		localsessionfactory.setHibernateProperties(initializeHibernatProps());
		return localsessionfactory;
	}

	public Properties initializeHibernatProps() {
		System.out.println("Dialectval : " + DIALECT_VAL);
		Properties proper = new Properties();
		proper.put(Environment.DIALECT, DIALECT_VAL);
		proper.put(Environment.SHOW_SQL, true);
		proper.put(Environment.HBM2DDL_AUTO, "update");
		return proper;
	}

	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		System.out.println("Username : " + USERNAME_VAL);
		ds.setDriverClassName(DRIVERCLASS_VAL);
		ds.setUrl(DB_URL_VAL);
		ds.setUsername(USERNAME_VAL);
		ds.setPassword(PASSWORD_VAL);
		return ds;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/Pages/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
}
