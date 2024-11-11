package com.rancho_smart.ms_alimentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsAlimentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAlimentosApplication.class, args);
	}

}
