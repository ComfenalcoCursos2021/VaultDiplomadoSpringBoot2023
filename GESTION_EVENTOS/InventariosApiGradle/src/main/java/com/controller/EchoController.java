package com.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.utils.PersistenceUtils;

@Controller
public class EchoController {

	
	@GetMapping("/echo")
	public ResponseEntity<String> echo() throws Exception{
		PersistenceUtils.CONTADOR++;
		System.out.println(PersistenceUtils.CONTADOR);
		
		if(PersistenceUtils.CONTADOR % 5 != 0) {
			throw new Exception("Explote!");
		}
		
		String msg = "ECHO INVENTARIO API -> " +(new Date()).toString();
		System.out.println(msg);
		return ResponseEntity.ok(msg );
	}
}
