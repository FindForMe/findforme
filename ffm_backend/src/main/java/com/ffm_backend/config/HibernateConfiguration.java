package com.ffm_backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = {"com.ffm_backend.dto"})
@EnableTransactionManagement
public class HibernateConfiguration {

	//change below on the basis of DBMS you choose
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ffm?autoReconnect=true&useSSL=false";
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	private static final String DATABASE_USERNAME = "root";//makdb for server //root for local
	private static final String DATABASE_PASSWORD = "root";
	
	//dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL); 
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	//Session bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(gatHibernateProperties());
		builder.scanPackages("com.ffm_backend.dto");
		
		return builder.buildSessionFactory();
	}
	
	//Hibernate all properties will be returned in this method.
	private Properties gatHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	 
	//Transaction management Bean will be available here.
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory factory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(factory);
		
		return transactionManager;
	}
	
}
