package com.ecosistema.ventas.clients.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecosistema.ventas.clients.models.ProductoModel;
import com.ecosistema.ventas.globaldto.ResultadoDto;

@FeignClient("productos-service")
public interface IProductoClient {
	@GetMapping("/productos/{id}")
	public ResultadoDto<ProductoModel> findById(@PathVariable long id);
}
