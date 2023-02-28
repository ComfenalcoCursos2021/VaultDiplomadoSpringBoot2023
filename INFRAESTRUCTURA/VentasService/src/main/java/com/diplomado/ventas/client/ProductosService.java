package com.diplomado.ventas.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.model.ProductoModel;

@Service
public class ProductosService {

	@Autowired
	private ProductosClient productosClient;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	public ProductoModel getProductoById(long id) {
		ProductoModel producto = circuitBreakerFactory.create("getProductoById").run(() -> {
			return this.productosClient.findByIdClient(id);
		}, throwable -> {
			return ProductoModel.builder().nombre("VACIO").build();
		});
		return producto;
	}

	private ProductoModel handle() {
		ProductoModel returnValue = new ProductoModel();
		returnValue.setNombre("VACIO");
		return returnValue;
	}

}
