package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.conexiones.IConexion;
import com.example.demo.dtos.UserDto;
import com.example.demo.entidades.OtraInyectada;
import com.example.demo.negocio.UserBl;
import com.example.demo.propiedades.ConexionProperties;

@Controller
public class TestController {	
	
	private OtraInyectada otraInyectada;
	private ConexionProperties connProp;
	private IConexion conexion;	
	private UserBl userBl;
	
	public TestController(
			OtraInyectada otraInyectada,
			ConexionProperties connProp,
			IConexion conexion,			
			UserBl userBl) {
		
		this.otraInyectada = otraInyectada;
		this.connProp = connProp;
		this.conexion = conexion;		
		this.userBl = userBl;
	}
	
	
	@GetMapping("/user")
	@ResponseBody
	public ResponseEntity<List<UserDto>> getUsers(){
		
		List<UserDto> usuarios = this.userBl.getUserList();
		return new ResponseEntity<List<UserDto>>(usuarios,HttpStatus.OK);
	}
	@PostMapping("/user")
	@ResponseBody
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto usuario){		
		return new ResponseEntity<UserDto>(this.userBl.guardar(usuario),HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	@ResponseBody
	public ResponseEntity<Boolean> deleteUser(@PathVariable long id){
		
			return new ResponseEntity<Boolean>(this.userBl.borrar(id),HttpStatus.OK);	
		
		
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
