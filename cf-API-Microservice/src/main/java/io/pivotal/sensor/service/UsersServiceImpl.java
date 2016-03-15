package io.pivotal.sensor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.pivotal.sensor.model.User;

@Service
public class UsersServiceImpl implements UsersService {

	//TODO Eureka
	final String uri = "http://sensors-microservice.cfapps.io/";

	//TODO inject
    RestTemplate restTemplate = new RestTemplate();

	@Override
	public Iterable<User> findAllUsers() {
		// return getDummyData();
		return restTemplate.getForObject(uri + "get-all-users", Iterable.class);
	}

}
