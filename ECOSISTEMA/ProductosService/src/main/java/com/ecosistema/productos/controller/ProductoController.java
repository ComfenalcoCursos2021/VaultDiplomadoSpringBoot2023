package com.ecosistema.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecosistema.productos.bl.ProductoBl;
import com.ecosistema.productos.dto.ProductoDto;
import com.ecosistema.productos.globaldto.ResultadoDto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoBl productoBl;
	
	
	@GetMapping
	public ResultadoDto<List<ProductoDto>> findAll(){
		return this.productoBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<ProductoDto> findById(@PathVariable long id){
		return this.productoBl.findById(id);
	}
	
	@PostMapping
	public ResultadoDto<ProductoDto> save(@RequestBody ProductoDto producto){
		return this.productoBl.save(producto);
	}
	@PutMapping
	public ResultadoDto<ProductoDto> update(@RequestBody ProductoDto producto){
		return this.productoBl.update(producto);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto<String> delete(@PathVariable long id){
		return this.productoBl.delete(id);
		
	}
}
