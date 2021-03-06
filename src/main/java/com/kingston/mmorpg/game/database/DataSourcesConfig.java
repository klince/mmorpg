package com.kingston.mmorpg.game.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourcesConfig {
	
	@Bean(name = "configDataSource")
	@Qualifier("configDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.configdb")
	public DataSource primaryDataSource() {
		System.out.println("primary db built");
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "userDataSource")
	@Qualifier("userDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.userdb")
	public DataSource secondaryDataSource() {
		System.out.println("secondary db built");
		return DataSourceBuilder.create().build();
	}
}
