/**
 * 
 */
package fpt.database.config;

import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author YenDV
 *
 */
@Configuration
@EnableJpaRepositories(
	entityManagerFactoryRef = "entityManagerFactory",
	transactionManagerRef = "transactionManager",
	basePackages = {"fpt.repository"}
)
public class DatabaseConfig {
	private final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);
	
	@Autowired
	public DatabaseConfig(Environment env) {
		logger.info("---------------Database config run--------------------");
	}
	
	@Primary
	@Bean(name = "datasourceProperties")
	@ConfigurationProperties(prefix="cf.datasource")
	protected DataSourceProperties getDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	private DataSource createDataSource(DataSourceProperties properties){
		return (DataSource) DataSourceBuilder.create(properties.getClassLoader()).type(DataSource.class)
				.driverClassName(properties.determineDriverClassName())
				.url(properties.determineUrl())
				.username(properties.determineUsername())
				.password(properties.determinePassword()).build();
	}
	
	@Primary
	@Autowired
	@Bean(name = "dataSource")
	public DataSource dataSource(@Qualifier("datasourceProperties") DataSourceProperties properties) {
		DataSource dataSource = createDataSource(properties);
		DatabaseDriver dbDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
		String validateQuery = dbDriver.getValidationQuery();
		if(validateQuery != null) {
			dataSource.setTestOnBorrow(true);
			dataSource.setValidationQuery(validateQuery);
		}
		return dataSource;
	}
	
	@Primary
	@Autowired
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityEntityMangerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean bean = builder.dataSource(dataSource)
				.packages("fpt.model")
				.persistenceUnit("mysql")
				.build();
		return bean;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManager) {
		return new JpaTransactionManager(entityManager);
	}
}
