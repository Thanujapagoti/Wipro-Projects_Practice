package com.wipro.thanuja.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer

@SpringBootApplication
public class ConfigServerLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerLibApplication.class, args);
	}

}
