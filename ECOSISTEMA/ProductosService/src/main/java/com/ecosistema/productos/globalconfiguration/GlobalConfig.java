package com.ecosistema.productos.globalconfiguration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
