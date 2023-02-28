package com.ecosistema.ventas.controller;

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

import com.ecosistema.ventas.bl.VentaBl;
import com.ecosistema.ventas.dto.VentaDto;
import com.ecosistema.ventas.globaldto.ResultadoDto;

@RestController
@RequestMapping("/ventas")
public class VentaController {
	@Autowired
	private VentaBl ventaBl;
	
	
	@GetMapping
	public ResultadoDto<List<VentaDto>> findAll(){
		return this.ventaBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<VentaDto> findById(@PathVariable long id){
		return this.ventaBl.findById(id);
	}
	
	@PostMapping
	public ResultadoDto<VentaDto> save(@RequestBody VentaDto venta){
		return this.ventaBl.save(venta);
	}
	@PutMapping
	public ResultadoDto<VentaDto> update(@RequestBody VentaDto venta){
		return this.ventaBl.update(venta);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto<String> delete(@PathVariable long id){
		return this.ventaBl.delete(id);
		
	}
}
