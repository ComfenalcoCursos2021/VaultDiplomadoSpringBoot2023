package com.diplomado.ventas.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.model.ProductoModel;

@Service
public class ProductosService {

	@Autowired
	private ProductosClient productosClient;
	
	
	public ProductoModel getProductoById(long id) {		
		return productosClient.findByIdClient(id);
	}
	
}
