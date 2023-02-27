



package com.diplomado.ventas.controller;

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

import com.diplomado.ventas.bl.VentasBl;
import com.diplomado.ventas.dtos.VentasDto;
import com.diplomado.ventas.globaldto.ResultadoDto;

@RestController
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	private VentasBl ventasBl;
	
	
	@GetMapping
	public ResultadoDto<List<VentasDto>> findAll(){
		return this.ventasBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<VentasDto> findById(@PathVariable long id){
		return this.ventasBl.findById(id);
	}
	
	@PostMapping
	public ResultadoDto<VentasDto> save(@RequestBody VentasDto ventas){
		return this.ventasBl.save(ventas);
	}
	@PutMapping
	public ResultadoDto<VentasDto> update(@RequestBody VentasDto ventas){
		return this.ventasBl.update(ventas);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto delete(@PathVariable long id){
		return this.ventasBl.delete(id);
		
	}
}




