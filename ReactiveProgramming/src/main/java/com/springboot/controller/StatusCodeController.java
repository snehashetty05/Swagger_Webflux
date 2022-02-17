package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/status")
public class StatusCodeController {
	
	@Autowired
	WebClient webClient;
	

	@GetMapping("/ok")
	public void ok(){
		Mono<HttpStatus> status = webClient.get()
                .uri("http://httpbin.org/status/500")
                .exchange()
                .map(response -> response.statusCode().OK);
	}
}