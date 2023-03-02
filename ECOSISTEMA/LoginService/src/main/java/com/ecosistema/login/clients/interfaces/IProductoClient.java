package com.ecosistema.login.clients.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecosistema.login.clients.models.ProductoModel;
import com.ecosistema.login.globaldto.ResultadoDto;

@FeignClient("productos-service")
public interface IProductoClient {
	@GetMapping("/productos/{id}")
	public ResultadoDto<ProductoModel> findById(@PathVariable long id);
}
