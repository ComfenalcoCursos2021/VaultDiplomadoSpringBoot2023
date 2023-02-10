package com.eventcontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventcontrol.bl.AsistentesBl;
import com.eventcontrol.dtos.AsistentesDto;
import com.eventcontrol.dtos.AsistentesMinDto;

@Controller
@RequestMapping("/asistentes")
public class AsisntentesController {

	@Autowired
	private AsistentesBl asistentesBl;
	
	@GetMapping
	public ResponseEntity<List<AsistentesDto>> findAll(){
		return ResponseEntity.ok(asistentesBl.findAll());
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<AsistentesMinDto> findAll(@PathVariable long id){
		return ResponseEntity.ok(asistentesBl.findMinById(id));
	}
	@GetMapping("/minall")
	public ResponseEntity<List<AsistentesMinDto>> findAllMin(){
		return ResponseEntity.ok(asistentesBl.findAllMin());
	}
}
