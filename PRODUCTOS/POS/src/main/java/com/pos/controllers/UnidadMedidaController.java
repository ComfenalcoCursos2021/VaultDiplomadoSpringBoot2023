package com.pos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pos.bl.UnidadMedidaBl;
import com.pos.dtos.UnidadMedidaDto;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/unidadmedida")
public class UnidadMedidaController {

	@Autowired
	private UnidadMedidaBl unidadMedidaBl;
	
	@GetMapping
	public ResponseEntity<List<UnidadMedidaDto>> findAll(){
		///return new ResponseEntity<List<UnidadMedidaDto>>(unidadMedidaBl.findAll(), HttpStatus.OK);
		return ResponseEntity.ok(unidadMedidaBl.findAll());
	}
	@GetMapping("/pages")
	public ResponseEntity<List<UnidadMedidaDto>> findAll(
			@RequestParam(required = false) int page, 
			@RequestParam int size){
		///return new ResponseEntity<List<UnidadMedidaDto>>(unidadMedidaBl.findAll(), HttpStatus.OK);
		return ResponseEntity.ok(unidadMedidaBl.findAll(page , size));
	}	
	@GetMapping("/pages/{page}/{size}")
	public ResponseEntity<List<UnidadMedidaDto>> findAllBack(@PathVariable int page, 
														@PathVariable int size){
		///return new ResponseEntity<List<UnidadMedidaDto>>(unidadMedidaBl.findAll(), HttpStatus.OK);
		return ResponseEntity.ok(unidadMedidaBl.findAll(page , size));
	}	
	
	@PostMapping
	public ResponseEntity<UnidadMedidaDto> save(
			@Valid 
			@RequestBody 
			UnidadMedidaDto nuevo,			
			BindingResult result) {
		//return ResponseEntity.ok(unidadMedidaBl.save(nuevo));
		if(result.hasErrors()) {
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(nuevo);
	}
	
	
}
