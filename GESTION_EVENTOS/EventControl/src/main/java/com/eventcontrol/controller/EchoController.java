package com.eventcontrol.controller;

import java.util.Date;
import java.util.concurrent.Callable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;

@RestController
@RequestMapping("/app")
public class EchoController {

	//@Autowired
	//private RestTemplate restTemplate;
	
	@GetMapping("/echo")
	public ResponseEntity<String> echo(){
		var msg =  "ECHO EVENT CONTROL -> " +(new Date()).toString() ; 
		System.out.println(msg);
		return ResponseEntity.ok(msg);
	}
	@PostMapping("/external")
	public Object callExternal() {
		
		
		CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("httpRequest");

		Callable<String> restrictedCall = CircuitBreaker.decorateCallable(circuitBreaker, () -> callExternalRetry());


		try {
		    String result = restrictedCall.call();
		    System.out.println(result);
		} catch (Exception e) {
		    System.out.println("Request failed");
		}
		
		return callExternalRetry();
	}
	
	private String callExternalRetry() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://randomuser.me/api/";
		url = "http://localhost:8090/echo";
	    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	    String result = response.getBody();
	    return result;
	}
	
}
