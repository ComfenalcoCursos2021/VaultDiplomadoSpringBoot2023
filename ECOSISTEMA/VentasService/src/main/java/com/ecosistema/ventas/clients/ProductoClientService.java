package com.ecosistema.ventas.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.ecosistema.ventas.clients.interfaces.IProductoClient;
import com.ecosistema.ventas.clients.models.ProductoModel;
import com.ecosistema.ventas.globaldto.ResultadoDto;

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
