


package com.diplomado.ventas.globalconfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfiguration {
	@Bean
	public ModelMapper getModel() {
		return new ModelMapper();
	}
}

