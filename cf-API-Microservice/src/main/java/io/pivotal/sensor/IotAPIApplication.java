package io.pivotal.sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class IotAPIApplication {

	
    public static void main(String[] args) {
        SpringApplication.run(IotAPIApplication.class, args);
    }
    
    @Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
