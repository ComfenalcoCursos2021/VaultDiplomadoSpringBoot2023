package com.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EchoController {

	@GetMapping("/echo")
	public ResponseEntity<String> echo(){
		String msg = "ECHO INVENTARIO API -> " +(new Date()).toString();
		System.out.println(msg);
		return ResponseEntity.ok(msg );
	}
}
