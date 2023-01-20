package com.example.demo.configuraciones;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.conexiones.IConexion;
import com.example.demo.conexiones.MySqlConexion;
import com.example.demo.conexiones.SqlServerConexion;
import com.example.demo.propiedades.ConexionProperties;

@Configuration
@EnableConfigurationProperties(ConexionProperties.class)
public class ConfiguracionGeneral {

	private ConexionProperties properties;
	public ConfiguracionGeneral(ConexionProperties properties) {
		this.properties = properties;
	}
	
	@Bean
	public IConexion getConexion() {
		if(properties.getMotor().toUpperCase().equals("MYSQL")) {
			return new MySqlConexion();	
		}
		return new SqlServerConexion();		
	}
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder data = DataSourceBuilder.create();
		data.driverClassName("org.h2.Driver");
		data.url("jdbc:h2:mem:testdb");
		data.username("SA");
		data.password("");		
		return data.build();
	}
	
	@Bean
	public ModelMapper getModel() {
		return new ModelMapper();
	}
	
}
