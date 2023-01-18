package com.example.demo.configuraciones;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
}
