package com.pan.sample1.dataaccess.config;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.jolbox.bonecp.BoneCPDataSource;
@Configuration
@ComponentScan(basePackages={"com.pan.sample1.dataaccess.model","com.pan.sample1.dataaccess.repository","com.pan.sample1.dataaccess.service"})
@ImportResource("classpath:dataaccess-context.xml")
@PropertySource("classpath:dataaccess.properties")
public class Sample1Config {
	
	private static final String PName_DB_Driver="db.driver";
	private static final String PName_DB_Password="db.password";
	private static final String PName_DB_Url="db.url";
	private static final String PName_DB_UserName="db.username";
	
	private static final String PName_Hibernate_Dialect="hibernate.dialect";
	private static final String PName_Hibernate_Format_SQL="hibernate.format_sql";
	
	
	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	private static final String PROPERTY_NAME_PERSISTENCE_UNIT_NAME = "entitymanager.persistence.unit.name";

	@Resource
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();

		dataSource.setDriverClass(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setJdbcUrl(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		// DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//
		// dataSource.setDriverClassName(environment
		// .getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		// dataSource.setUrl(environment
		// .getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		// dataSource.setUsername(environment
		// .getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		// dataSource.setPassword(environment
		// .getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager()
			throws ClassNotFoundException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(this
				.entityManagerFactoryBean().getObject());

		return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
			throws ClassNotFoundException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(this.dataSource());

		entityManagerFactoryBean
				.setPackagesToScan("com.pan.sample1.dataaccess.model");
		entityManagerFactoryBean
				.setPersistenceProviderClass(HibernatePersistence.class);

		//set empty persisent unit name to enable auditable, this is STRANGE!
		entityManagerFactoryBean.setPersistenceUnitName(environment
				.getRequiredProperty(PROPERTY_NAME_PERSISTENCE_UNIT_NAME));

		Properties jpaProterties = new Properties();
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

		entityManagerFactoryBean.setJpaProperties(jpaProterties);

		// HibernateJpaVendorAdapter jpaVendorAdapter = new
		// HibernateJpaVendorAdapter();
		// jpaVendorAdapter.setGenerateDdl(true);
		// jpaVendorAdapter.setShowSql(true);
		// jpaVendorAdapter.setDatabase(Database.MYSQL);
		// entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);

		return entityManagerFactoryBean;
	}

}
