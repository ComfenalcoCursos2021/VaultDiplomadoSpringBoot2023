package com.ecosistema.login.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.ecosistema.login.clients.interfaces.IProductoClient;
import com.ecosistema.login.clients.models.ProductoModel;
import com.ecosistema.login.globaldto.ResultadoDto;

@Service
public class ProductoClientService {

	@Autowired
	private IProductoClient productoClient;
	
	@Autowired CircuitBreakerFactory circuitBreaker;
	
	public ProductoModel getProducto(long id) {
		
			ResultadoDto<ProductoModel> resultado = 
					this.circuitBreaker.create("getProducto")
						.run(()->{
							return productoClient.findById(id);
						},
						throwable -> {
							return ResultadoDto.<ProductoModel>ok(null);
						});
					
					
			return resultado.getData();	
		
		
	}
}
