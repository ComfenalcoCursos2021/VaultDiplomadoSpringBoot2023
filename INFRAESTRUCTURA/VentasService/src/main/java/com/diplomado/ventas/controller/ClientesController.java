



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

import com.diplomado.ventas.bl.ClientesBl;
import com.diplomado.ventas.dtos.ClientesDto;
import com.diplomado.ventas.globaldto.ResultadoDto;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClientesBl clientesBl;
	
	
	@GetMapping
	public ResultadoDto<List<ClientesDto>> findAll(){
		return this.clientesBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<ClientesDto> findById(@PathVariable long id){
		return this.clientesBl.findById(id);
	}
	
	@PostMapping
	public ResultadoDto<ClientesDto> save(@RequestBody ClientesDto clientes){
		return this.clientesBl.save(clientes);
	}
	@PutMapping
	public ResultadoDto<ClientesDto> update(@RequestBody ClientesDto clientes){
		return this.clientesBl.update(clientes);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto delete(@PathVariable long id){
		return this.clientesBl.delete(id);
		
	}
}




