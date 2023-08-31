package com.rabin.inventorystock.restApiproject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@LocalServerPort
	private int port;
	
	private String baseUrl="http://localhost";
	
	private static RestTemplate restTemplate;
	
	@BeforeAll
	public static void init() {
		restTemplate=new RestTemplate();
	}
	
	@BeforeEach
	public void setup() {
		baseUrl=baseUrl.concat(":").concat(port + "").concat("/rabin");//:8080/rabin
	}
	

}
