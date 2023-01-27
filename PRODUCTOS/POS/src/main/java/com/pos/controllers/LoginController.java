package com.pos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.dtos.UserDto;

@RestController
@RequestMapping("/loginDeprecated")
public class LoginController {

	@PostMapping
	public ResponseEntity<String> getLogin(@RequestBody UserDto user){
		return ResponseEntity.ok("ROOT");
	}
}
