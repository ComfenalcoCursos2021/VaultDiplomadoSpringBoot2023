



package com.diplomado.bodegas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diplomado.bodegas.bl.ProductosBl;
import com.diplomado.bodegas.dtos.ProductosDto;
import com.diplomado.bodegas.globaldto.ResultadoDto;

@RestController
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductosBl productosBl;
	
	
	@GetMapping
	public ResultadoDto<List<ProductosDto>> findAll(){
		return this.productosBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<ProductosDto> findById(@PathVariable long id){
		return this.productosBl.findById(id);
	}
	
	@GetMapping("/client/{id}")
	public ProductosDto findByIdClient(@PathVariable long id){
		return this.productosBl.findById(id).getData();
	}
	
	@PostMapping
	public ResultadoDto<ProductosDto> save(@RequestBody ProductosDto productos){
		return this.productosBl.save(productos);
	}
	@PutMapping
	public ResultadoDto<ProductosDto> update(@RequestBody ProductosDto productos){
		return this.productosBl.update(productos);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto delete(@PathVariable long id){
		return this.productosBl.delete(id);
		
	}
}




