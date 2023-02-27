package com.diplomado.ventas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.diplomado.ventas.globaldto.ResultadoDto;
import com.diplomado.ventas.model.ProductoModel;

@FeignClient(name="bodegas-service", path="/productos")
public interface ProductosClient {

	@GetMapping("/client/{id}")
	public ProductoModel findByIdClient(@PathVariable long id);
	@GetMapping("/{id}")
	public ResultadoDto<ProductoModel> findById(@PathVariable long id);
}
