package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // this will make a micro service register itself with config server
public class OAuthMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthMsApplication.class, args);
	}
}
