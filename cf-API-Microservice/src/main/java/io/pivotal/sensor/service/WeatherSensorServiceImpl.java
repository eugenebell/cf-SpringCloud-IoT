package io.pivotal.sensor.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.pivotal.sensor.model.Weather;

@Service
public class WeatherSensorServiceImpl implements WeatherSensorService {

	private static final Logger LOG = LoggerFactory.getLogger(WeatherSensorServiceImpl.class);
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	private String getURL() {
		InstanceInfo ii = discoveryClient.getNextServerFromEureka("climate-ms", false);
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
	@HystrixCommand(fallbackMethod = "defaultFindBySensorID")
	public Iterable<Weather> findBySensorID(String sensorID) {
		return restTemplate.getForObject(getURL() + "get-weather-by-sensorid/" + sensorID, Iterable.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "defaultFindWeatherSensorReadingBetween")
	public Iterable<Weather> findWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime) {
		return restTemplate.getForObject(getURL() + "get-all-weather-readings-by-sensorid/" + sensorID + "/between/"
				+ sdf.format(startTime) + "/" + sdf.format(endTime), Iterable.class);
	}

	public Iterable<Weather> defaultFindBySensorID(String sensorID) {
		return new ArrayList<Weather>();
	}

	public Iterable<Weather> defaultFindWeatherSensorReadingBetween(String sensorID, Date startTime, Date endTime) {
		return new ArrayList<Weather>();
	}
}
