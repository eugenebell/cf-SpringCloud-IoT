package io.pivotal.iot.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//http://cloud.spring.io/spring-cloud-static/spring-cloud.html#spring-cloud-eureka-server
public class CfEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfEurekaServerApplication.class, args);
    }
}
