package com.diplomado.ventas.client;

import com.diplomado.ventas.globaldto.ResultadoDto;
import com.diplomado.ventas.model.ProductoModel;


public class ProductosHystrixFallBack implements ProductosClient {
	@Override
	public ProductoModel findByIdClient(long id) {

		return ProductoModel.builder().nombre("vacio").precioCosto(-10d).precioVenta(-10d).build();
	}

	@Override
	public ResultadoDto<ProductoModel> findById(long id) {
		// TODO Auto-generated method stub
		return ResultadoDto.<ProductoModel>ok(ProductoModel.builder().nombre("vacio").precioCosto(-10d).precioVenta(-10d).build());
	}

}
