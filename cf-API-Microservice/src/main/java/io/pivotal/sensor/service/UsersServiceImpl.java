package io.pivotal.sensor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.pivotal.sensor.model.User;

@Service
public class UsersServiceImpl implements UsersService {

	//TODO Eureka
//	final String uri = "http://sensors-microservice.cfapps.io/";
	final String uri = "http://localhost:8888/";

	@Autowired
    RestTemplate restTemplate;

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindAllUsers")
	public Iterable<User> findAllUsers() {
		return restTemplate.getForObject(uri + "get-all-users", Iterable.class);
	}

	public Iterable<User> defaultFindAllUsers() {
		return new ArrayList<User>();
    }
}
