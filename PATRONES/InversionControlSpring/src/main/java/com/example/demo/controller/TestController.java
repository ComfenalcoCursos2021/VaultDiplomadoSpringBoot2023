package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.conexiones.IConexion;
import com.example.demo.entidades.OtraInyectada;
import com.example.demo.propiedades.ConexionProperties;

@Controller
public class TestController {

	
	
	private OtraInyectada otraInyectada;
	private ConexionProperties connProp;
	private IConexion conexion;
	
	public TestController(OtraInyectada otraInyectada,ConexionProperties connProp,IConexion conexion) {
		
		this.otraInyectada = otraInyectada;
		this.connProp = connProp;
		this.conexion = conexion;
	}
	
	
	@GetMapping("/user")
	@ResponseBody
	public ResponseEntity<String> getUsers(){
		return new ResponseEntity<String>("Esta la lista de usuarios -> " + connProp.getMotor(),HttpStatus.OK);
	}
	@PostMapping("/user")
	@ResponseBody
	public ResponseEntity<String> saveUser(){
		return new ResponseEntity<String>("Esta guardando =>Conexion=>" + conexion.getConexion(),HttpStatus.OK);
	}
	@DeleteMapping("/user")
	@ResponseBody
	public ResponseEntity<String> deleteUser(){
		return new ResponseEntity<String>("Esta Borrando",HttpStatus.OK);
	}
	@PutMapping("/user")
	@ResponseBody
	public ResponseEntity<String> updateUser(){
		return new ResponseEntity<String>("Esta Actualizando",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	@RequestMapping("/")
	@ResponseBody
	public ResponseEntity<String> servicioWebRaiz(){
		return new ResponseEntity<String>("el mensaje",HttpStatus.OK);
	}
	/*
	@RequestMapping("/hoy")
	@ResponseBody
	public ResponseEntity<String> servicioWebOtro(){
		return new ResponseEntity<String>(injectada.getDate(),HttpStatus.OK);
	}*/
	
	@RequestMapping("/hoyv2")
	@ResponseBody	
	public ResponseEntity<String> servicioWebHoyV2(){
		return new ResponseEntity<String>(otraInyectada.getDate(),HttpStatus.OK);
	}
	
}
