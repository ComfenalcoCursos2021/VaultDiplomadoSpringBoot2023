package com.eventcontrol.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class EchoController {

	@GetMapping("/echo")
	public ResponseEntity<String> echo(){
		var msg =  "ECHO EVENT CONTROL -> " +(new Date()).toString() ; 
		System.out.println(msg);
		return ResponseEntity.ok(msg);
	}
}
