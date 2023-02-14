package com.eventcontrol.controller;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.Callable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;

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
	
	private Duration getDuration() {
		return Duration.ofSeconds(1);
		
	}
	
	@PostMapping("/external")
	public Object callExternal() throws Exception {
		
		
		
		RetryConfig config = RetryConfig.custom()
				.retryExceptions(Exception.class)
				.maxAttempts(3)
				.intervalFunction(IntervalFunction.of(Duration.ofMillis(2000), (x) -> {System.out.println("Viendo como se avanza -> "+x);return x * 2;}))
			    .build();
		
		
		Retry retry = Retry.of("id",config);

		Callable<String> restrictedCall = Retry
			    .decorateCallable(retry, () -> callExternalRetry());
			    


		/*try {
		    String result = restrictedCall.call();
		    System.out.println(result);
		} catch (Exception e) {
		    System.out.println("Request failed");
		}*/
		
		return restrictedCall.call();
	}
	
	private String callExternalRetry() {
		System.out.println("INTENTANDO ");
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://randomuser.me/api/";
		url = "http://localhost:8090/echo";
	    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	    String result = response.getBody();
	    System.out.println(result);
	    return result;
	}
	
}
