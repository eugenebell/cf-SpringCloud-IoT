package io.pivotal.sensor.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.pivotal.sensor.model.User;

@Service
public class UsersServiceImpl implements UsersService {

	private static final Logger LOG = LoggerFactory.getLogger(UsersServiceImpl.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	private String getURL() {
		InstanceInfo ii = discoveryClient.getNextServerFromEureka("rfid-switch-ms", false);
		LOG.debug("Home Page Url :" + ii.getHomePageUrl());
		LOG.debug("Host Name :" + ii.getHostName());
		LOG.debug("VIP Address :" + ii.getVIPAddress());
		LOG.debug("IP Addr :" + ii.getIPAddr());
		LOG.debug("Port :" + ii.getPort());
		LOG.debug("App Name:" + ii.getAppName());
		LOG.debug("Status Page Url :" + ii.getStatusPageUrl());
		LOG.debug("Secure Port :" + ii.getSecurePort());
		return ii.getHomePageUrl();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindAllUsers")
	public Iterable<User> findAllUsers() {
		return restTemplate.getForObject(getURL() + "get-all-users", Iterable.class);
	}

	public Iterable<User> defaultFindAllUsers() {
		return new ArrayList<User>();
    }
}
