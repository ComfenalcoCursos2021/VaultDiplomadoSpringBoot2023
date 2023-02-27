



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

import com.diplomado.bodegas.bl.ExistenciasBl;
import com.diplomado.bodegas.dtos.ExistenciasDto;
import com.diplomado.bodegas.globaldto.ResultadoDto;

@RestController
@RequestMapping("/existencias")
public class ExistenciasController {

	@Autowired
	private ExistenciasBl existenciasBl;
	
	
	@GetMapping
	public ResultadoDto<List<ExistenciasDto>> findAll(){
		return this.existenciasBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<ExistenciasDto> findById(@PathVariable long id){
		return this.existenciasBl.findById(id);
	}
	
	@PostMapping
	public ResultadoDto<ExistenciasDto> save(@RequestBody ExistenciasDto existencias){
		return this.existenciasBl.save(existencias);
	}
	@PutMapping
	public ResultadoDto<ExistenciasDto> update(@RequestBody ExistenciasDto existencias){
		return this.existenciasBl.update(existencias);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto delete(@PathVariable long id){
		return this.existenciasBl.delete(id);
		
	}
}




