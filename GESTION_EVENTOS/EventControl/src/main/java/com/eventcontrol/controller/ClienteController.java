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

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteBl clienteBl;
	
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll(){
		return ResponseEntity.ok(this.clienteBl.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> findById(@PathVariable long id){
		return ResponseEntity.ok(this.clienteBl.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto cliente){
		return ResponseEntity.ok(this.clienteBl.save(cliente));
	}
	@PutMapping
	public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto cliente){
		return ResponseEntity.ok(this.clienteBl.update(cliente));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable long id){
		this.clienteBl.delete(id);
		return (ResponseEntity) ResponseEntity.ok();
	}
}
