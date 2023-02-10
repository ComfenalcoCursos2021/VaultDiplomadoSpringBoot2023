package com.eventcontrol.controller;

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

import com.eventcontrol.bl.ClienteBl;
import com.eventcontrol.dtos.ClienteDto;
import com.eventcontrol.globaldto.ResultadoDto;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteBl clienteBl;
	
	
	@GetMapping
	public ResultadoDto<List<ClienteDto>> findAll(){
		return this.clienteBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<ClienteDto> findById(@PathVariable long id){
		return this.clienteBl.findById(id);
	}
	
	@PostMapping
	public ResultadoDto<ClienteDto> save(@RequestBody ClienteDto cliente){
		return this.clienteBl.save(cliente);
	}
	@PutMapping
	public ResultadoDto<ClienteDto> update(@RequestBody ClienteDto cliente){
		return this.clienteBl.update(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto delete(@PathVariable long id){
		return this.clienteBl.delete(id);
		
	}
}
