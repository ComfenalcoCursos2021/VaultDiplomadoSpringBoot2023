



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

import com.diplomado.bodegas.bl.BodegasBl;
import com.diplomado.bodegas.dtos.BodegasDto;
import com.diplomado.bodegas.globaldto.ResultadoDto;

@RestController
@RequestMapping("/bodegas")
public class BodegasController {

	@Autowired
	private BodegasBl bodegasBl;
	
	
	@GetMapping
	public ResultadoDto<List<BodegasDto>> findAll(){
		return this.bodegasBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<BodegasDto> findById(@PathVariable long id){
		return this.bodegasBl.findById(id);
	}
	
	@PostMapping
	public ResultadoDto<BodegasDto> save(@RequestBody BodegasDto bodegas){
		return this.bodegasBl.save(bodegas);
	}
	@PutMapping
	public ResultadoDto<BodegasDto> update(@RequestBody BodegasDto bodegas){
		return this.bodegasBl.update(bodegas);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto delete(@PathVariable long id){
		return this.bodegasBl.delete(id);
		
	}
}




