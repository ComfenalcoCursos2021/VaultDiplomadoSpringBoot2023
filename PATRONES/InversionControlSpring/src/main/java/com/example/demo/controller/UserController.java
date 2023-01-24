package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDto;
import com.example.demo.negocio.UserBl;

@RestController
@RequestMapping(value="user")
public class UserController {

	private UserBl userBl;
	
	public UserController(UserBl userBl) {
		this.userBl = userBl;
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<UserDto>> getUsers(){
		
		List<UserDto> usuarios = this.userBl.getUserList();
		return new ResponseEntity<List<UserDto>>(usuarios,HttpStatus.OK);
	}
	
	@GetMapping("/buscadornombre")
	@ResponseBody
	public ResponseEntity<List<UserDto>> getUsers(@RequestParam String nombre){		
		List<UserDto> usuarios = this.userBl.getListContains(nombre);
		return new ResponseEntity<List<UserDto>>(usuarios,HttpStatus.OK);
	}
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto usuario){		
		return new ResponseEntity<UserDto>(this.userBl.guardar(usuario),HttpStatus.OK);
	}
	
	@PostMapping("/bulk")
	@ResponseBody
	public ResponseEntity<String> saveUser(@RequestBody List<UserDto> usuarios){		
		return new ResponseEntity<String>(String.valueOf(this.userBl.guardarBulk(usuarios)),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Boolean> deleteUser(@PathVariable long id){
		
			return new ResponseEntity<Boolean>(this.userBl.borrar(id),HttpStatus.OK);	
		
		
	}
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user, @PathVariable long id){
		return new ResponseEntity<UserDto>(this.userBl.actualizar(user, id),HttpStatus.OK);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user){
		return new ResponseEntity<UserDto>(this.userBl.actualizar(user),HttpStatus.OK);
	}
}
